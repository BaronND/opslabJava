package JavaIO.ZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author 禅师
 * @resume 解压demo2的zip文件
 */
public class demo5 {

    public static void main(String[] args) throws IOException, ZipException {
        File file = new File("C:\\test.zip");
        ZipFile zipFile = new ZipFile(file);

        File newFile = null;

        ZipInputStream zipInput =                                //用于遍历zip文件
                new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        InputStream input = null;                //用于从每一个zipEntry对应的文件中读取数据
        OutputStream output = null;                //用于每个ZipEntry对应的文件输出数据流


        //遍历解压
        while ((entry = zipInput.getNextEntry()) != null) {
            System.out.println("正则解压文件：" + entry.getName());
            newFile = new File("C:\\" + entry.getName());
            if (!(newFile.getParentFile().exists())) {
                newFile.getParentFile().mkdir();
            }
            if (!(newFile.exists())) {
                newFile.createNewFile();
            }
            output = new FileOutputStream(newFile);
            input = zipFile.getInputStream(entry);

            int temp = 0;
            while ((temp = input.read()) != -1) {
                output.write(temp);
            }


            output.close();
            input.close();
        }
        System.out.print("解压完成");
        zipInput.close();
        zipFile.close();
    }

}
