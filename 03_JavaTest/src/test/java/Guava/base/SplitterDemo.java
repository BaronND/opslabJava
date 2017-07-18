package Guava.base;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class SplitterDemo {
    @Test
    public void test() {
        // String.split悄悄丢弃了尾部的分隔符
        String[] strs = ",a,,b,".split(",");
        System.out.println(Arrays.toString(strs));// [, a, , b]

        //omitEmptyStrings()-----从结果中自动忽略空字符串
        //trimResults()-----移除结果字符串的前导空白和尾部空白
        //trimResults(CharMatcher)-----给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
        //limit(int)-----限制拆分出的字符串数量

        //[a, b]
        Iterable<String> strsIt = Splitter.on(',').trimResults().omitEmptyStrings().split(",a,,b,");
        Iterator<String> it = strsIt.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        String testString = "Monday,Tuesday,,Thursday,Friday,,";
        // parts is [Monday, Tuesday, , Thursday,Friday]
        String[] parts = testString.split(",");

        // 可以分割
        System.out.println(Splitter.on("|").split("foo|bar|baz"));

        // 这样为什么不能分割？我一开始比较疑惑的就是，上面的例子传入的是 | 这为什么不需要转义？
        // 哈哈，on()方法传入的参数可以指定正则类，或者使用下面例子的方法传入正则。
        Splitter splitter = Splitter.on("\\d");
        System.out.println(splitter.split("abc1def2ccc3aaa9"));

        // 这样就可以按正则分割了
        Splitter splitter1 = Splitter.on(Pattern.compile("\\d")).trimResults().omitEmptyStrings();
        // 或者 Splitter splitter1 = Splitter.onPattern("\\d");
        System.out.println(splitter1.split("abc1def2ccc3aaa9"));

        // 在来看一个劲爆一点儿的例子，其实关于Map的处理真的是太需要了
        String startString = "Washington D.C=Redskins#New YorkCity=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");
        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(startString);
        System.out.println(splitMap);

    }
}
