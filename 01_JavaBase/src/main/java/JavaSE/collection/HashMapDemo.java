package JavaSE.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = null;
        map = new HashMap<String, String>();

        //insert-elements
        map.put("ch", "ChanShi");
        map.put("Email", "snake@163.com");
        map.put("bolg", "www.baidu.com");

        System.out.println("ch:" + map.get("ch"));
        System.out.println("Email:" + map.get("Email"));
        System.out.println("bolg:" + map.get("bolg"));

    }
}