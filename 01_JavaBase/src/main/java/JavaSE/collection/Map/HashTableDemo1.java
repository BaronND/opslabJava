package JavaSE.collection.Map;

import java.util.*;

public class HashTableDemo1 {


    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<String, String>();

        //向map中添加元素
        map.put("1111", "禅师");
        map.put("2222", "尼姑");
        map.put("3333", "方丈");
        map.put("4444", "和尚");
        map.put("5555", "师太");

        //取得全部的key 和 value
        Set<String> keySet = null;
        Collection<String> valSet = null;
        Iterator<String> keyIter = null;
        Iterator<String> valIter = null;

        keySet = map.keySet();
        valSet = map.values();
        keyIter = keySet.iterator();
        valIter = valSet.iterator();

        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String value = valIter.next();
            System.out.println("key : value -> " + key + " : " + value);
        }
    }

}
