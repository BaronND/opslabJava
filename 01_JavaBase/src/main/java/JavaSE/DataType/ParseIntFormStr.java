package JavaSE.DataType;

/************************************************
 *
 * @summary 演示将字符串转换为整数
 ************************************************/
public class ParseIntFormStr {
    public static void main(String[] args) {
        String str = "100";
        int x;
        x = Integer.parseInt(str);
        System.out.println(x);
    }
}
