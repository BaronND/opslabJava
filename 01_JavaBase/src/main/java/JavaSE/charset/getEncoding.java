package JavaSE.charset;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class getEncoding {
    public static void main(String[] args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String alias : map.keySet()) {
            System.out.println(alias);
        }
    }
}