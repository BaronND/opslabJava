package netty.jdkbio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池的方式实现
 * 因为采用了线程池的方式所以服务端的线程数量不会因为客户端数量急剧增加
 */
public class TimeServerPool {
    public static void main(String[] args) {
        //创建一个固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(4567)) {
            System.out.println("服务启动成功");
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
