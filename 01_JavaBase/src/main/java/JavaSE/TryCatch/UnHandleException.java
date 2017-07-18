package JavaSE.TryCatch;

/*******************************************
 *
 * @summary 演示程序中异常未处理的情况
 *******************************************/
public class UnHandleException {
    public static void main(String[] args) {
        int y = 10;
        int x = 0;
        int z = y / x;
        System.out.println("y/x =" + z);
    }
}
