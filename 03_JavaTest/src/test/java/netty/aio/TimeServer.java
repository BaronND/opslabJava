package netty.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * 使用AIO实现真正的异步处理服务端
 */
public class TimeServer implements Runnable{
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;




    public TimeServer(String host,int port) throws IOException {
        //创建异步socket通道
        asynchronousServerSocketChannel =
                AsynchronousServerSocketChannel.open();
        //绑定
        asynchronousServerSocketChannel.bind(new InetSocketAddress(host,port));
        System.out.println("time server is start in port:"+port);
    }

    @Override
    public void run() {
        while(true){
            //接受请求，在有效的请求到达后使用CompletionHandler接口实体去处理
            asynchronousServerSocketChannel.accept(this,
                    new CompletionHandler<AsynchronousSocketChannel, TimeServer>() {
                @Override
                public void completed(AsynchronousSocketChannel result, TimeServer attachment) {
                    attachment.asynchronousServerSocketChannel.accept(attachment,this);
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    result.read(buffer,buffer,new ReadCompletionHandler(result));
                }

                @Override
                public void failed(Throwable exc, TimeServer attachment) {

                }
            });
        }
    }

    private static class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer>{
        public ReadCompletionHandler(AsynchronousSocketChannel result) {
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {

        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {

        }
    }
}
