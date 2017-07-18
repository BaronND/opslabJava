package netty.jdknio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 异步客户端
 */
public class Client implements Runnable {
    private SocketChannel socketChannel;

    private Selector selector;

    private volatile boolean IS_CONNECTED = false;

    public Client(String host, int port) throws IOException {
        //创建选择器
        selector = Selector.open();
        //打开监听通道
        socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
        //如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
        socketChannel.configureBlocking(false);
        //注册读循环器
        socketChannel.register(selector, SelectionKey.OP_READ);

        //SocketChannel上并没有一种connect( )方法可以让您指定超时（timeout）值，
        // 当connect( )方法在非阻塞模式下被调用时SocketChannel提供并发连接：
        // 它发起对请求地址的连接并且立即返回值。
//        IS_CONNECTED = socketChannel.connect(new InetSocketAddress(host, port));
//        if(!IS_CONNECTED){
//            //相当于设置了3秒的超时时间
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("连接是否成功:" + socketChannel.isConnected());
        //链接

        IS_CONNECTED = socketChannel.isConnected();

    }

    public void sendMsg(String msg) throws IOException {
        if (IS_CONNECTED) {
            //将消息编码为字节数组
            byte[] bytes = msg.getBytes();
            //根据数组容量创建ByteBuffer
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //将字节数组复制到缓冲区
            writeBuffer.put(bytes);
            //flip操作
            writeBuffer.flip();
            //发送缓冲区的字节数组
            socketChannel.write(writeBuffer);
            //****此处不含处理“写半包”的代码
        } else {
            throw new IOException("未连接的服务器");
        }
    }

    @Override
    public void run() {
        while (IS_CONNECTED) {
            try {
                //无论是否有读写事件发生，selector每隔1s被唤醒一次
                selector.select(1000);
                //阻塞,只有当至少一个注册的事件发生的时候才会继续.
//              selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        //接受到信息后退出并是否资源
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (sc.finishConnect()) ;
                else System.exit(1);
            }
            //读消息
            if (key.isReadable()) {
                //创建ByteBuffer，并开辟一个1M的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取请求码流，返回读取到的字节数
                int readBytes = sc.read(buffer);
                //读取到字节，对字节进行编解码
                if (readBytes > 0) {
                    //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    buffer.flip();
                    //根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String result = new String(bytes, "UTF-8");
                    System.out.println("客户端收到消息：" + result);
                    //接受到信息后退出
                    IS_CONNECTED = false;
                }
                //没有读取到字节 忽略
//              else if(readBytes==0);
                //链路已经关闭，释放资源
                else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void close() {
        IS_CONNECTED = false;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static class ClientCall extends Thread{
        private String msg;
        private boolean OK = false;
        private Client client;
        public ClientCall( String msg) {
            this.msg = msg;
            try {
                client = new Client("127.0.0.1", 4567);
                new Thread(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                client.sendMsg(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 1000; i++) {
            (new ClientCall("msg"+i)).start();
        }
    }
}
