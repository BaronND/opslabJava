package JavaIO.ConvertStream;

import java.io.*;

/**
 * @author 禅师
 * @resume 将字节流转换为字符流
 */
public class demo1 {

    public static void main(String[] args) throws IOException {
        String path = "C:\\test.txt";
        File f = new File(path);
        Writer out = null;

        //将字节流转换为字符流
        out = new OutputStreamWriter(new FileOutputStream(f));

        String str = "hello world!!! 让程序改变世界";
        out.write(str);


        out.close();
    }

}
