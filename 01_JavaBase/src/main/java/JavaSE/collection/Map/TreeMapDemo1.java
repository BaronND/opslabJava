
package JavaSE.collection.Map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo1 {


    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();

        //向map中添加元素
        map.put("1111", "禅师");
        map.put("2222", "尼姑");
        map.put("3333", "方丈");
        map.put("4444", "和尚");
        map.put("5555", "师太");

        //迭代输入
        Iterator<String> keyIter = (map.keySet()).iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            System.out.println(key + " -> " + map.get(key));
        }
    }

}
