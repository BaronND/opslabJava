package JavaIO.ZipStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class zipdemo3 {
    public static void main(String[] args) throws Exception {
        File zipFile = new File("d:" + File.separator + "text.zip");
        ZipInputStream input = null;
        input = new ZipInputStream(new FileInputStream(zipFile));

        ZipEntry entry = input.getNextEntry();
        System.out.println("zip-entry-name:" + entry.getName());
    }
}