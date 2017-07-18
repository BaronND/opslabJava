package JavaIO.PrintStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class demo2 {

    public static void main(String[] args) throws IOException {
        File f = new File("c:\\test");
        PrintStream ps = null;
        ps = new PrintStream(new FileOutputStream(f));

        String name = "禅师";
        int age = 20;
        String job = "无业游民";

        ps.printf("姓名：%s \t年龄：%d \t工作:%s", name, age, job);
        ps.close();
    }

}
