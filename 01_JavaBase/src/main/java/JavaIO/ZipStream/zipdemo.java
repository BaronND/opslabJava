package JavaIO.ZipStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zipdemo {
    public static void main(String[] args) throws Exception {
        File file = new File("d:" + File.separator + "text.txt");

        File zipFile = new File("d:" + File.separator + "text.zip");

        InputStream input = new FileInputStream(file);
        ZipOutputStream zipOut = null;

        zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        zipOut.setComment("test zip util");
        int temp = 0;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }
        input.close();
        zipOut.close();
    }
}