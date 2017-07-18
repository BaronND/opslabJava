package netty.jdkbio;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class TimeClient {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new TimeClientHandler("127.0.0.1", 4567)).start();
        }
    }

    public static class TimeClientHandler implements Runnable {
        private String ip;
        private int port;

        public TimeClientHandler(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            BufferedReader in = null;
            PrintWriter out = null;
            try (Socket socket = new Socket(ip, port)) {
                InputStream inputStream = socket.getInputStream();
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("QUERY TIME ORDER");
                byte[] bytes = new byte[1024];
                inputStream.read(bytes);

                System.out.println(name + "=> time:" + new String(bytes,"UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
