package JavaSE.DataType;

/*******************************************
 *
 * @summary JDK1.5后自动装箱和自从拆箱技术
 ******************************************/

@SuppressWarnings("unused")
public class AutoWrapsClass {
    public static void main(String[] args) {
        Integer i = 30;    //自动装箱
        Float f = 3.0f; //自动装箱


        int x = i;        //自动拆箱
        float ff = f;    //自动拆箱
    }
}
