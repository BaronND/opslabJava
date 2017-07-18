package JavaIO.ZipStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class demo4 {

    public static void main(String[] args) throws IOException {

        File file = new File("c:\\test.zip");

        ZipInputStream input = null;
        input = new ZipInputStream(new FileInputStream(file));

        ZipEntry temp = null;
        while ((temp = input.getNextEntry()) != null) {
            System.out.println(temp.getName());
        }

        input.close();
    }

}
