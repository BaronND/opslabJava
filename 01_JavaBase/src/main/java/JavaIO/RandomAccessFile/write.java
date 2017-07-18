package JavaIO.RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 禅师
 * @resume 写数据到文件。支持随机访问
 */
public class write {


    public static void main(String[] args) throws IOException {
        String path = "c:\\test.dat";
        File file = new File(path);
        RandomAccessFile wdf = null;
        try {
            //以读写方式打开文件，会自动新建文件
            wdf = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            System.out.println("RandomAccessFile ：" + path + "异常");
            e.printStackTrace();
        }

        String name = "chanshi  ";
        int age = 20;
        wdf.writeBytes(name);
        wdf.writeInt(age);

        name = "nigu     ";
        wdf.writeBytes(name);
        wdf.writeInt(age);

        name = "fangzhang";
        wdf.writeBytes(name);
        wdf.writeInt(age);


        //关闭句柄
        wdf.close();

    }

}
