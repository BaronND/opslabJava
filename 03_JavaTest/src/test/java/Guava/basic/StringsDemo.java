package Guava.basic;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Strings也是一个方便的类
 */
public class StringsDemo {

    @org.junit.Test
    public void test1() {
        StringBuilder builder = new StringBuilder("foo");
        char c = 'x';
        for (int i = 0; i < 3; i++) {
            builder.append(c);
        }
        System.out.println(Strings.padEnd(builder.toString(), 20, 'y'));

        System.out.println(Strings.repeat("abc", 3));
        System.out.println(Strings.emptyToNull("") == null);
        System.out.println("hahhhh");
    }

    /**
     * 连接器[Joiner]
     */
    @org.junit.Test
    public void testJoiner() {
        // .on("; ")以，分隔 ;.skipNulls()忽略null
        Joiner joiner = Joiner.on("; ").skipNulls();
        String aString = joiner.join("aaa", null, "bbb", "ccc");
        System.out.println(aString);// aaa; bbb; ccc

        // useForNull(String)方法可以给定某个字符串来替换null
        joiner = Joiner.on("; ").useForNull("ccc");
        aString = joiner.join("aaa", null, "bbb", "ccc");
        System.out.println(aString);// aaa; ccc; bbb; ccc

        Joiner.on(";").join(Arrays.asList(1, 5, 7)); // returns "1;5;7"
        // joiner实例总是不可变的。用来定义joiner目标语义的配置方法总会返回一个新的joiner实例。
        // 这使得joiner实例都是线程安全的，你可以将其定义为static final常量。
    }

    /**
     * 拆分器[Splitter]
     */
    @org.junit.Test
    public void testSplitter() {
        // String.split悄悄丢弃了尾部的分隔符
        String[] strs = ",a,,b,".split(",");
        System.out.println(Arrays.toString(strs));// [, a, , b]


        //omitEmptyStrings()-----从结果中自动忽略空字符串
        //trimResults()-----移除结果字符串的前导空白和尾部空白
        //trimResults(CharMatcher)-----给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
        //limit(int)-----限制拆分出的字符串数量
        Iterable<String> strsIt = Splitter.on(',').trimResults()
                .omitEmptyStrings().split(",a,,b,");//[a, b]
        Iterator<String> it = strsIt.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
