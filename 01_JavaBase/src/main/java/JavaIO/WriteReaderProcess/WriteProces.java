package JavaIO.WriteReaderProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author 禅师
 * @resume 建立一个cmd子进程，并执行ipconfig命令
 */
public class WriteProces {

    public static void main(String[] args) throws IOException {
        Process pro = Runtime.getRuntime().exec("cmd.exe");

        BufferedReader read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        PrintStream write = new PrintStream(pro.getOutputStream());
        String buff = null;
        for (int i = 0; i < 10; i++) {
            buff = read.readLine();
            System.out.println(buff);

        }


        write.println("ipconfig /all");
        for (int i = 0; i < 10; i++) {
            buff = read.readLine();
            System.out.println(buff);

        }


    }

}
