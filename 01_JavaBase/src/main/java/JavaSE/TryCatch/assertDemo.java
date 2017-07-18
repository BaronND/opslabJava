package JavaSE.TryCatch;

/****************************************
 *
 * @summary 演示Java中的断言
 ****************************************/
public class assertDemo {
    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        assert x.length == 0 : "数组长度不为0";
    }
}
