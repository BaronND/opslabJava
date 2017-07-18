package JavaSE.IntegerTest;

import java.math.BigInteger;

/**
 * @majorfunction 测试字符串00转行成整数后的结果
 */
public class ParseInt_00 {
    public static void main(String[] args) {

        String str = "00";
        int temp = Integer.parseInt(str);
        System.out.println(temp);
        System.out.println(Integer.toBinaryString(111111111));
        System.out.println((new BigInteger("11111111111111111111199")).toString(2));
    }

}
