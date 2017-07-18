package JavaIO.WriteReaderProcess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author 禅师
 * @document 利用Runtime实例执行ping 192.168.1.2并将结构回显
 */
public class ReadFromProcess {

    public static void main(String[] args) throws Exception {
        String command = "ping 192.168.1.2";

        Process process = Runtime.getRuntime().exec(command);
        BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String buff = null;
        while ((buff = buf.readLine()) != null) {
            System.out.println(buff);
        }
    }

}
