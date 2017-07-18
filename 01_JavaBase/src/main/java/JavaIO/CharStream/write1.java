package JavaIO.CharStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 禅师
 * @resume 利用字符流写入数据
 */
public class write1 {

    public static void main(String[] args) throws IOException {
        String path = "c:\\test3.txt";
        File f = new File(path);
        Writer out = null;
        out = new FileWriter(f);

        String str = "hello world!!!编程能改变世界";
        out.write(str);
        out.close();
    }

}
