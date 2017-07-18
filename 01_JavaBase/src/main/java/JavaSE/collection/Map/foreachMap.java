package JavaSE.collection.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 禅师
 * @resume 利用foreach进行map输出
 */
public class foreachMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("1111", "禅师");
        map.put("2222", "尼姑");
        map.put("3333", "方丈");
        map.put("4444", "和尚");
        map.put("5555", "师太");


        //利用foreach语法输出map
        for (Map.Entry<String, String> element : map.entrySet()) {
            System.out.println("key : value -> " + element.getKey() + " : " + element.getValue());
        }
    }

}
