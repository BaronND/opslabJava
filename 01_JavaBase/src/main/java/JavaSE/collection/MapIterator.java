package JavaSE.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIterator {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        //insert-elements
        map.put(new String("BT"), new String("www.baidu.com"));
        map.put(new String("lolo"), new String("lol.qq.com"));
        map.put(new String("QQ"), new String("im.qq.com"));

        //iterator-print
        Set<Map.Entry<String, String>> set = null;
        set = map.entrySet();
        Iterator<Map.Entry<String, String>> iter = null;
        iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> temp = iter.next();
            System.out.println(temp.getKey() + "--->" + temp.getValue());
        }
    }
}