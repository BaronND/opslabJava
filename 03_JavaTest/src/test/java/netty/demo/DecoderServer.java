package netty.demo;

import com.opslab.util.DateUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.base64.Base64;

import java.net.InetSocketAddress;
import java.util.List;


public class DecoderServer {
    public void bind(String host,int port) throws InterruptedException {
        //配置俩组NIO线程组,一组用于数据传输,一组用于接受请求
        //NioEventLoopGroup实际上就是Reactor线程池,负责调度和执行客户端的介入
        //网络读写事件的处理、用户自定义方法和定时任务的执行
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup =  new NioEventLoopGroup();

        try {
            //启动并绑定监听
            ServerBootstrap boot = new ServerBootstrap();
            boot.group(bossGroup, workerGroup)
                    //绑定服务端的类型
                    .channel(NioServerSocketChannel.class)
                    //设定套接字参数
                    //backlog表示为此套接字排队的最大连接数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //绑定真正的请求处理类
                    .childHandler(new ChannelInitializer<SocketChannel>(){
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new DecodeHandler(),
                                    new DecoderServer.DecoderServerHandler());

                        }
                    });
            //事实端口绑定,并等待同步成功
            ChannelFuture future = boot.bind(new InetSocketAddress(host, port)).sync();

            System.out.println("TimeServer is started in port:"+port);
            //等待服务器端口监听关闭
            future.channel().closeFuture().sync();

        }finally {
            //是否线程资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class DecodeHandler extends ByteToMessageDecoder{

        protected void decode(ChannelHandlerContext channelHandlerContext,
                              ByteBuf byteBuf, List<Object> list) throws Exception {
            //            int size = byteBuf.readableBytes();
//            byte[] bytes = new byte[size];
//            byteBuf.readBytes(bytes);
            ByteBuf decode = Base64.decode(byteBuf);
            list.add(decode);
        }
    }

    private class DecoderServerHandler extends ChannelHandlerAdapter {
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            //读取信息
            ByteBuf buf = (ByteBuf)msg;
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            String content = new String(bytes,"UTF-8");
            System.out.println("server receive:"+content);


            //给客户端响应
            ByteBuf result  = Unpooled.copiedBuffer(DateUtil.currentDateTime().getBytes());
            ctx.write(result);
            //ctx.writeAndFlush(result);

        }
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //当读操作完成后不刷新的话,客户端是收不到响应结果的
            ctx.flush();
        }



    }

    public static void main(String[] args) throws InterruptedException {
        new TimeServer().bind("127.0.0.1",4567);
    }
}
