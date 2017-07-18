package JavaSE.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class IpAddress {


    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("cmd /c hostname");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String buff = null;

        while ((buff = br.readLine()) != null) {

            if ("snake".equals(buff)) {
                System.out.println("1111111111");
            }

        }


    }

}
