package JavaIO.File;

import java.io.*;

/***************************************************
 * @summary 演示JavaIo流从文件中一行一行的读取数据
 ***************************************************/
public class ReadLineFromFile {


    public static String file_name = "C:\\windows\\system.ini";

    public static void main(String[] args) throws IOException {

        BufferedReader SBUF = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File(file_name)))
        );
        String str = null;
        while ((str = SBUF.readLine()) != null) {
            System.out.println(str);
        }

        SBUF.close();
    }
}
