package JavaIO.PrintStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class demo1 {


    public static void main(String[] args) throws IOException {
        File f = new File("c:\\test");
        PrintStream ps = null;

        ps = new PrintStream(new FileOutputStream(f));

        ps.print("你好");
        ps.print(1111);

        ps.close();
    }

}
