package netty.jdkbio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 采用传统的BIO实现一个时间服务器(block-io)
 *
 * 采用该种放是服务端socket和客户端请求的数量成正比,因此其利弊很明显
 */
public class TimeServer {
    private static int port = 4567;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Time server start!");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
