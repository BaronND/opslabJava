package netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 使用netty编写客户端
 */
public class TimeClient {
    public void connection(String host,int port) throws InterruptedException {
        //配置NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap boot = new Bootstrap();
        boot.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new TimeClientHandler());
                    }
                });

        //发起异步链接操作
        ChannelFuture channelFuture = boot.connect(host, port).sync();

        //等待客户端链路关闭
        channelFuture.channel().closeFuture().sync();

        group.shutdownGracefully();

    }

    /**
     * 处理响应结果
     */
    private class TimeClientHandler extends ChannelHandlerAdapter{
        private final ByteBuf msg;

        public TimeClientHandler() {
            msg = Unpooled.copiedBuffer("QUERY TIME ORDER".getBytes());
        }


        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            //给服务器发送消息
            ctx.writeAndFlush(msg);
            //下面的操作会出现TCP粘包的情况
//            for (int i = 0; i < 100; i++) {
//                ctx.writeAndFlush(msg);
//                ctx.writeAndFlush(Unpooled.copiedBuffer("QUERY TIME ORDER".getBytes()));
//            }

        }

        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            //接受服务器返回的消息
            ByteBuf receive = (ByteBuf) msg;
            byte[] bytes = new byte[receive.readableBytes()];
            receive.readBytes(bytes);
            String content = new String(bytes,"UTF-8");
            System.out.println("return msg:"+content);
        }
    }



    public static void main(String[] args) throws InterruptedException {
        new TimeClient().connection("127.0.0.1",1111);
    }
}
