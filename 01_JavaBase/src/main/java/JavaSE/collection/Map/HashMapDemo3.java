package JavaSE.collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 禅师
 * @resume 将map中全部key输出为set集合
 */
public class HashMapDemo3 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        //向map中添加元素
        map.put("1111", "禅师");
        map.put("2222", "尼姑");
        map.put("3333", "方丈");
        map.put("4444", "和尚");
        map.put("5555", "师太");

        //将key输出为set
        Set<String> keySet = map.keySet();
        Iterator<String> setIter = keySet.iterator();
        while (setIter.hasNext()) {
            String key = setIter.next();
            System.out.print(key + "\t");
        }

    }

}
