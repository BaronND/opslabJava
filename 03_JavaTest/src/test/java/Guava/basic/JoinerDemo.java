package Guava.basic;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JoinerDemo {
    public static void main(String[] args) {

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 4. mapjoiner
        MapJoiner mapJoiner = Joiner.on("#").withKeyValueSeparator("=");
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "valuea");
        map.put("b", "valueb");
        map.put("c", "valuec");
        System.out.println(mapJoiner.join(map));
    }
}
