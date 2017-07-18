package JavaIO.ByteStream_VS_CharStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharWrite {

    public static void main(String[] args) throws IOException {
        String path = "c:\\test2.txt";
        File f = new File(path);
        Writer file = null;
        file = new FileWriter(f);

        String str = "hello world!!! 让编程改变世界";

        file.write(str);

        //将其注释，会发现内容并没有写入文件中
        file.close();

    }

}
