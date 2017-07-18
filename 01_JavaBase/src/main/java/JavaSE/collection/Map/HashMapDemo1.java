package JavaSE.collection.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo1 {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        //向map中添加元素
        map.put("1111", "禅师");
        map.put("2222", "尼姑");
        map.put("3333", "方丈");
        map.put("4444", "和尚");
        map.put("5555", "师太");

        //根据key获取响应的value
        String name = map.get("1111");
        System.out.println("key : 1111 -> value :" + name);

        System.out.println(map);

    }

}
