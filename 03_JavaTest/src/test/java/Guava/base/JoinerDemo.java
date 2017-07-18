package Guava.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import org.junit.Test;

/**
 * Created by Administrator on 2015-04-14.
 */
public class JoinerDemo {

    @Test
    public void test() {

        // joiner实例总是不可变的。用来定义joiner目标语义的配置方法总会返回一个新的joiner实例。
        // 这使得joiner实例都是线程安全的，你可以将其定义为static final常量。

        // .on("; ")以，分隔 ;.skipNulls()忽略null
        Joiner joiner = Joiner.on("; ").skipNulls();
        String aString = joiner.join("aaa", null, "bbb", "ccc");

        // aaa; bbb; ccc
        System.out.println(aString);

        // useForNull(String)方法可以给定某个字符串来替换null
        joiner = Joiner.on("; ").useForNull("ccc");
        aString = joiner.join("aaa", null, "bbb", "ccc");

        // aaa; ccc; bbb; ccc
        System.out.println(aString);

        // returns "1;5;7"
        String str = Joiner.on(";").join(Arrays.asList(1, 5, 7));
        System.out.println(str);

        StringBuilder builder = new StringBuilder("foo");
        System.out.println(Joiner.on(":").appendTo(builder, new Object[]{"c", "a", "c"}));

        // 1. Basic
        String[] array = {"abcd", "efgh", null, "jklm"};
        System.out.println(Joiner.on("|").skipNulls().join(array));

        // 2. Null Values
        System.out.println(Joiner.on("|").useForNull("***").join(array));

        // 3. Used with Appendable
        try {
            FileWriter fw = new FileWriter(new File("JoinerDemo.txt"), true);
            Joiner.on("##").skipNulls().appendTo(fw, array);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. mapjoiner
        MapJoiner mapJoiner = Joiner.on("&").withKeyValueSeparator("=");
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "valuea");
        map.put("b", "valueb");
        map.put("c", "valuec");
        System.out.println(mapJoiner.join(map));
    }
}
