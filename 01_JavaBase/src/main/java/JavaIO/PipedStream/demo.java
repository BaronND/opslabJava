package JavaIO.PipedStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class demo {

    public static void main(String[] args) {
        Send send = new Send();
        Receive receive = new Receive();

        try {
            send.getPos().connect(receive.getPis());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(send, "send").start();
        new Thread(receive, "rece").start();
    }

}

class Send implements Runnable {
    private PipedOutputStream pos = null;

    public Send() {
        pos = new PipedOutputStream();
    }

    @Override
    public void run() {


        String str = "hello world";

        //每5秒法一次数据
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            try {
                pos.write(str.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public PipedOutputStream getPos() {
        return pos;
    }

    public void setPos(PipedOutputStream pos) {
        this.pos = pos;
    }


}

class Receive implements Runnable {
    private PipedInputStream pis = null;


    public Receive() {
        pis = new PipedInputStream();
    }

    @Override
    public void run() {


        byte temp[] = new byte[20];
        int len = 0;

        //没六秒读一次数据
        while (true) {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                len = pis.read(temp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(new String(temp, 0, len));
        }
    }

    public PipedInputStream getPis() {
        return pis;
    }

    public void setPis(PipedInputStream pis) {
        this.pis = pis;
    }

}