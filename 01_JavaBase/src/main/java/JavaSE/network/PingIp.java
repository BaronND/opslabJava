package JavaSE.network;

import java.io.IOException;
import java.net.InetAddress;

public class PingIp {


    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByAddress(new byte[]{(byte) 127, (byte) 0, (byte) 0, (byte) 1});
        System.out.println(ip.isReachable(3000));
    }

}
