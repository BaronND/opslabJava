package JavaSE.commStruct;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Send implements Runnable {
    private PipedOutputStream pos = null;

    public Send() {
        this.pos = new PipedOutputStream();
    }

    public void run() {
        String str = "hello ";
        try {
            this.pos.write(str.getBytes());
            this.pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getPos() {
        return this.pos;
    }
}

class Receive implements Runnable {
    private PipedInputStream pis = null;

    public Receive() {
        this.pis = new PipedInputStream();
    }

    public void run() {
        byte b[] = new byte[1024];
        int len = 0;

        try {
            len = this.pis.read(b);
            this.pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Receive:" + new String(b, 0, len));
    }


    public PipedInputStream getPis() {
        return pis;
    }
}

public class piped {
    public static void main(String[] args) {
        Send s = new Send();
        Receive r = new Receive();
        try {
            s.getPos().connect(r.getPis());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(s).start();
        new Thread(r).start();
    }
}