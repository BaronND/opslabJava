package JavaIO.ZipStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * @author 禅师
 * @resume 完成demo1中的zip文件的解压缩
 */
public class demo3 {

    public static void main(String[] args) throws IOException {
        ZipFile zipfile = new ZipFile(new File("c:\\test.zip"));
        File file = new File("c:\\test_unzip.txt");

        OutputStream out = new FileOutputStream(file);

        ZipEntry temp = zipfile.getEntry("test.txt");

        //System.out.println(temp);
        java.io.InputStream in = zipfile.getInputStream(temp);

        int i = 0;
        while ((i = in.read()) != -1) {
            out.write(i);
        }
        in.close();
        out.close();
        zipfile.close();
    }

}
