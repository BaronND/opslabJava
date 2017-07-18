package Runtime;



import java.io.IOException;

/**
 * 执行系统命令
 */
public class RuntimeExec {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("cmd dir ./");
        System.out.println(exec.toString());
    }

}
