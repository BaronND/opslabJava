package JavaIO.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class read3 {


    public static void main(String[] args) throws Exception {

        String path = "C:\\test.txt";
        File f = new File(path);
        InputStream in = null;
        in = new FileInputStream(f);

        //根据文件大小建立数组
        byte temp[] = new byte[(int) f.length()];

        in.read(temp);
        System.out.println(new String(temp));
        in.close();
    }

}
