package JavaSE.collection.Map;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo1 {

    public static void main(String[] args) {
        SortedMap<String, String> sortMap = new TreeMap<String, String>();

        //向map中添加元素
        sortMap.put("1111", "禅师");
        sortMap.put("2222", "尼姑");
        sortMap.put("3333", "方丈");
        sortMap.put("4444", "和尚");
        sortMap.put("5555", "师太");

        //使用foreach输出
        for (Entry<String, String> element : sortMap.entrySet()) {
            System.out.println("key : value -> " + element.getKey() + " : " + element.getValue());
        }
    }

}
