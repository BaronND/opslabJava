package JavaIO.CharStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class addWrite {

    public static void main(String[] args) throws IOException {
        String path = "c:\\test.txt";
        File f = new File(path);
        Writer out = null;
        out = new FileWriter(f, true);

        String str = "hello world!!!编程能改变世界，吊丝逆袭靠知识\r\n";
        out.write(str);
        out.close();
    }

}
