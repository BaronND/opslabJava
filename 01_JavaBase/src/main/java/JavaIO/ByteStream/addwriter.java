package JavaIO.ByteStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author 禅师
 * @resume 内容追加
 */
public class addwriter {

    public static void main(String[] args) throws Exception {

        String path = "C:\\test.txt";
        File f = new File(path);

        OutputStream out = null;
        out = new FileOutputStream(f, true);

        String str = "编程能改变世界，吊丝逆袭靠知识\r\n";
        byte temp[] = str.getBytes();

        out.write(temp);
        out.close();
    }


}
