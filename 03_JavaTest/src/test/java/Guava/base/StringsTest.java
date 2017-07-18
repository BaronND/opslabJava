package Guava.base;

import com.google.common.base.Strings;
import org.junit.Test;


/**
 * String相关的一些方法
 */
public class StringsTest {
    /**
     * 测试String相关的一些通用函数
     */
    @Test
    public void testCommonFunction() {
        String prefix = "pre_";
        String str1 = "pre_test1";
        String str2 = "pre_test2";
        System.out.println("判断俩个字符串是否以相同的前缀开始：" + (str1.startsWith(prefix) && str2.startsWith(prefix)));
        System.out.println("返回俩个字符串的相同前缀：" + Strings.commonPrefix(str1, str2));

        String suffix = "_vo";
        String str3 = "test1_vo";
        String str4 = "test2_vo";
        System.out.println("判断俩个字符串是否以相同的后缀结尾:" + (str3.endsWith(suffix) && str4.endsWith(suffix)));
        System.out.println("返回俩个字符串的相同后缀:" + Strings.commonSuffix(str3, str4));

        String str5 = "test";
        String str6 = null;
        //如果字符串有效则返回，否则返回字符串null
        System.out.println("->" + Strings.emptyToNull(str5));
        System.out.println("->" + Strings.emptyToNull(str6));

        String str7 = null;
        String str8 = "";
        String str9 = "      ";
        //判断字符串是为null或者是空字符串
        System.out.println("->" + Strings.isNullOrEmpty(str7));
        System.out.println("->" + Strings.isNullOrEmpty(str8));
        System.out.println("->" + Strings.isNullOrEmpty(str9));

        //将null字符串或者空字符串转换""字符串
        System.out.println("->" + Strings.nullToEmpty(str7));
        System.out.println("->" + Strings.nullToEmpty(str8));
        System.out.println("->" + Strings.nullToEmpty(str9));

        String strs1 = "test1";
        String strs2 = "test2_ss";
        //将字符串用指定字符在尾部补长至指定的长度
        System.out.println("->" + Strings.padEnd(strs1, 10, 'b'));
        //将字符串用指定字符在头部补长至指定的长度
        System.out.println("->" + Strings.padStart(strs2, 10, 'b'));
        //字符串的乘法
        System.out.println("->" + Strings.repeat(strs2, 10));
    }


}
