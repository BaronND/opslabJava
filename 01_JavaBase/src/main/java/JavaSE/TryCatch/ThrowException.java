package JavaSE.TryCatch;

/*************************************************
 *
 * @summary 演示Java中手动抛出异常对象
 *************************************************/
public class ThrowException {
    public static void main(String[] args) {
        try {
            throw new Exception("自己实例化的异常对象");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
