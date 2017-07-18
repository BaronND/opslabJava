package JavaIO.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author 禅师
 * @resume 读取内容
 */
public class read {

    public static void main(String[] args) throws Exception {
        String path = "C:\\test.txt";
        InputStream in = null;
        in = new FileInputStream(new File(path));

        byte temp[] = new byte[1024];

        in.read(temp);

        //此处将有很多空格出现
        System.out.println("读取到内容为：\n" + new String(temp));

        in.close();
    }

}
