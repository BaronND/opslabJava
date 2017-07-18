package JavaIO.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 禅师
 * @resume 读取文件内容
 */
public class read2 {


    public static void main(String[] args) throws Exception {
        String path = "C:\\test.txt";
        InputStream in = null;
        in = new FileInputStream(new File(path));

        byte temp[] = new byte[1024];
        int len = in.read(temp);

        System.out.println("内容长度:" + len);
        System.out.println(new String(temp, 0, len));

        in.close();

    }

}
