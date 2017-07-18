package JavaIO.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class read4 {

    public static void main(String[] args) throws Exception {
        String path = "C:\\test.txt";
        File f = new File(path);
        InputStream in = null;
        in = new FileInputStream(f);

        byte temp[] = new byte[(int) f.length()];
        for (int i = 0; i < f.length(); i++) {
            temp[i] = (byte) in.read();
        }

        System.out.println(new String(temp));
        in.close();
    }

}
