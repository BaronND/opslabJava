package JavaIO.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class read5 {

    public static void main(String[] args) throws Exception {
        String path = "C:\\test.txt";
        File f = new File(path);
        InputStream in = null;
        in = new FileInputStream(f);

        byte temp[] = new byte[(int) f.length()];
        int i = 0;
        int len = 0;
        //in.read()的返回值不是-1就表示文件还没有读完
        while ((i = in.read()) != -1) {

            temp[len] = (byte) i;
            len++;
        }
        System.out.println(new String(temp));
        in.close();
    }

}
