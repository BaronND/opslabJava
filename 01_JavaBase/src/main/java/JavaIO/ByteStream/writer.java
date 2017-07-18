package JavaIO.ByteStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author 禅师
 * @resume 以字节流写数据到文件
 */
public class writer {


    public static void main(String[] args) throws Exception {

        String path = "c:\\test1.txt";
        File f = new File(path);

        //因为OutputStream是字节输出操作的抽象类，此处操作的是文件，所有用文件输出流实例化
        //每次写都是重写
        OutputStream out = null;
        out = new FileOutputStream(f);

        String str = "hello world!!! 让程序改变世界";
        byte temp[] = str.getBytes();

        out.write(temp);

        out.close();
    }

}
