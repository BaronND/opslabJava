package JavaIO.RandomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 禅师
 * @resume 读取支持随机访问的文件
 */
public class Read {

    public static void main(String[] args) throws IOException {
        String path = "C:\\test.dat";
        File file = new File(path);
        RandomAccessFile rdf = null;

        try {
            rdf = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            System.out.println("RandomAccessFile:" + path + "异常");
            e.printStackTrace();
        }


        String name;
        int age;

        byte temp[] = new byte[9];
        //读取nigu的信息
        rdf.skipBytes(13);
        rdf.readFully(temp);
        age = rdf.readInt();
        name = new String(temp);
        System.out.println(name);
        System.out.println(age);

        rdf.seek(0);
        rdf.readFully(temp);
        age = rdf.readInt();
        name = new String(temp);
        System.out.println(name);
        System.out.println(age);

        rdf.seek(26);
        rdf.readFully(temp);
        age = rdf.readInt();
        name = new String(temp);
        System.out.println(name);
        System.out.println(age);

    }

}
