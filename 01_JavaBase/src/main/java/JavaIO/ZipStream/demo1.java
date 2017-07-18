package JavaIO.ZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 禅师
 * @resume 使用java.util.zip包中的zip压缩相关的类完成文件压缩
 */
public class demo1 {


    public static void main(String[] args) throws IOException {
        /**
         * 将C:\test.txt文件压缩为test.zip
         */

        File file = new File("C:\\test.txt");
        File zipFile = new File("c:\\test.zip");

        //创建输入流和输出流   及读被压缩的文件的句柄 和 压缩文件的写句柄
        InputStream input = new FileInputStream(file);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

        //在java中每个压缩文件项都用ZipEntry标识

        //向zip文件中添加文件
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        zipOut.setComment("演示利用java怎么实现zip压缩");
        //实际向zip文件中边读边写入数据
        int temp = 0;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }


        //关闭输入和输出流
        input.close();
        zipOut.close();

    }

}
