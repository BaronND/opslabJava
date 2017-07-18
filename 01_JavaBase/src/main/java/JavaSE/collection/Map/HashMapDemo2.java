package JavaSE.collection.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo2 {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        //向map中添加元素
        map.put("1111", "禅师");
        map.put("2222", "尼姑");
        map.put("3333", "方丈");
        map.put("4444", "和尚");
        map.put("5555", "师太");

        //判断是否有3333这个一个key
        if (map.containsKey("3333")) {
            System.out.println("有3333这样的key");
        } else {
            System.out.println("没有3333这样的key");
        }

        //判断是否有禅师这个value
        if (map.containsValue("禅师")) {
            System.out.println("有禅师");
        } else {
            System.out.println("没有有禅师");
        }


    }

}
