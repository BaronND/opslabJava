package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.net.InetSocketAddress;

/**
 * 使用netty实现简单的HTTP服务器
 *      将制定的目录以http服务的形式提供
 */
public class SimpleHttpServerDemo {
    public void server(String host, int port, final String path) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        try{
            ServerBootstrap boot = new ServerBootstrap();




            boot.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-decoder",new HttpRequestDecoder());
                            ch.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65535));
                            ch.pipeline().addLast("http-encode",new HttpResponseEncoder());
                            ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                            ch.pipeline().addLast("fileServer",new SimpleHttpFileServerHandler(path));
                        }
                    });

            ChannelFuture channelFuture =
                    boot.bind(new InetSocketAddress(host, port)).sync();
            System.out.println("Server is started in port:"+host+":"+port+"/"+path);
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new SimpleHttpServerDemo().server("127.0.0.1",8000,"c:/");
    }
}
