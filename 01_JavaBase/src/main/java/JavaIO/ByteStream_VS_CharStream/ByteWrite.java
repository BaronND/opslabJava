package JavaIO.ByteStream_VS_CharStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteWrite {
    public static void main(String[] args) throws IOException {
        String path = "C:\\test1.txt";
        File f = new File(path);
        OutputStream out = null;
        out = new FileOutputStream(f);

        String str = "hello world!!! 让编程改变世界";
        System.out.println(str);
        out.write(str.getBytes());

        //将其注释，看文件中是否写入内容.字节流没有使用缓冲区所以已经写入到文件中
        out.close();
    }

}
