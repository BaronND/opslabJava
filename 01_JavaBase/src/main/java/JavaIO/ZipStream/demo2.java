package JavaIO.ZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author 禅师
 * @resume 实现文件夹的压缩
 */
public class demo2 {

    public static void main(String[] args) throws IOException {
        /*
		 * 将c:\test文件演示为c:\test.zip
		 */
        File file = new File("c:\\test");
        File zipFile = new File("c:\\test.zip");

        InputStream input = null;
        ZipOutputStream zipOut = null;

        //实例zip文件写入流
        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

        zipOut.setComment("c:\\test文件夹的备份");

        if (file.isDirectory()) {
            File list[] = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                input = new FileInputStream(list[i]);

                ZipEntry zip = new ZipEntry(file.getName() + File.separator + list[i].getName());

                zipOut.putNextEntry(zip);
                int temp = 0;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
                input.close();
            }
        }

        //释放zip文件写入流
        zipOut.close();
    }

}
