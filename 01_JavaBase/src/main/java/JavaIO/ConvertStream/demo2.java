package JavaIO.ConvertStream;

import java.io.*;

public class demo2 {

    public static void main(String[] args) throws IOException {

        String path = "c:\\test.txt";
        File f = new File(path);

        Reader in = null;
        in = new InputStreamReader(new FileInputStream(f));

        char temp[] = new char[1024];
        int len = in.read(temp);
        System.out.println(new String(temp, 0, len));
        in.close();
    }

}
