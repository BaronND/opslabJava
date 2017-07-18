package JavaIO.CharStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 禅师
 * @resume Writer类及其子类使用了缓冲区技术。因此在写入数据时，未必能及时将数据写到文件中。
 * 此时可以采用flush函数强制性刷新缓冲区，将数据写入到文件中
 */
public class flush {

    public static void main(String[] args) throws IOException {
        String path = "C:\\test3.txt";
        File f = new File(path);
        Writer file = null;
        file = new FileWriter(f);

        String str = "hello world!!! 让编程改变世界";
        file.write(str);
        file.flush();

        //将其注释，数据依然已经写入到文件中
        file.close();
    }

}
