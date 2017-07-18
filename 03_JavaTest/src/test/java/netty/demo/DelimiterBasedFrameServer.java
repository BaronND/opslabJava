package netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.net.InetSocketAddress;

/**
 * DelimiterBasedFrameDecoder可以自动完成以分割符做结束标志的消息的解码
 */
public class DelimiterBasedFrameServer {
    private static Logger logger = Logger.getLogger(DelimiterBasedFrameServer.class);

    /**
     * 在指定的地址上启动服务
     * @param host ip地址
     * @param port 端口
     * @param delimiter 消息分隔符
     */
    private void service(String host,int port,final String delimiter) throws InterruptedException {
        logger.info("The service is ready to start:"+host+":"+port+"/delimiter:"+delimiter);
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //设置分割符解码器
                            ByteBuf delimiters = Unpooled.copiedBuffer(delimiter.getBytes());
                            //第一个参数单条消息的最长长度,第二个参数为分隔符
                            DelimiterBasedFrameDecoder delimiterBasedFrameDecoder =
                                    new DelimiterBasedFrameDecoder(1024, delimiters);
                            socketChannel.pipeline().addLast(delimiterBasedFrameDecoder);

                            //设置字符编码器和解码器
                            socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                            socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));

                            //设置业务处理类
                            socketChannel.pipeline().addLast(new DelimiterServerHandler(delimiter));
                        }
                    });


            ChannelFuture future =boot.bind(new InetSocketAddress(host,port)).sync();
            logger.info("The service is started:"+host+":"+port+"/delimiter:"+delimiter);

            //等待服务器端口监听关闭
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class DelimiterServerHandler extends ChannelHandlerAdapter{
        private final String delimiter;
        private long count;
        private DelimiterServerHandler(String delimiter) {
            this.delimiter = delimiter;
        }


        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            count++;
            String content = (String)msg;
            System.out.println("Server receive msg["+count+"]:"+content);

            String result = "server say:"+content+delimiter;
            ByteBuf returnMsg = Unpooled.copiedBuffer(result.getBytes());
            ctx.writeAndFlush(returnMsg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new DelimiterBasedFrameServer().service("127.0.0.1",4567,"$");
    }
}
