package netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

/**
 * DelimiterBasedFrameDecoder可以自动完成以分割符做结束标志的消息的解码
 */
public class DelimiterBasedFrameClient {

    public void connection(String host,int port,final String delimiter) throws InterruptedException {
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            Bootstrap boot = new Bootstrap();
            boot.group(worker).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ByteBuf delimiters = Unpooled.copiedBuffer(delimiter.getBytes());

                            socketChannel.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
                            socketChannel.pipeline().addLast(
                                    new DelimiterBasedFrameDecoder(1024, delimiters));
                            socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                            socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                            socketChannel.pipeline().addLast(new DelimiterClientHandler(delimiter));
                        }
                    });

            ChannelFuture future = boot.connect(host, port).sync();

            //等待客户端链路关闭
            future.channel().closeFuture().sync();
        }finally {
            worker.shutdownGracefully();
        }

    }

    private class DelimiterClientHandler extends ChannelHandlerAdapter{
        private final String delimiter;

        private DelimiterClientHandler(String delimiter) {
            this.delimiter = delimiter;
        }

        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            for (int i = 0; i < 100; i++) {
                String msg = "send "+i+delimiter;
                ctx.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
            }
        }

        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            String content = (String) msg;
            System.out.println("client receive:"+content);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new DelimiterBasedFrameClient().connection("127.0.0.1",4567,"$");
    }
}
