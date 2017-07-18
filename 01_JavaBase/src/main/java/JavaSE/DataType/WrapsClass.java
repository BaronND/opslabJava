package JavaSE.DataType;

/**********************************************
 *
 * @summary 演示Java的包装类
 **********************************************/
public class WrapsClass {
    public static void main(String[] args) {
        System.out.println("演示Java中包装类");
        int x = 30;
        Integer i = null;
        System.out.println("执行装箱操作:" + (i = new Integer(x)));
        System.out.println("执行拆箱操作:" + i.intValue());

    }
}
