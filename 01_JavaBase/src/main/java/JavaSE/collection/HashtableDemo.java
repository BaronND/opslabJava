package JavaSE.collection;

import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {
        Map<String, String> map = null;
        map = new Hashtable<String, String>();

        //insert-elements
        map.put("ch", "ChanShi");
        map.put("Email", "snake@163.com");
        map.put("bolg", "www.baidu.com");

        //get all-keys
        Set<String> keys = map.keySet();
        Iterator<String> iter1 = keys.iterator();
        System.out.println("all-keys:");
        while (iter1.hasNext()) {
            System.out.print(iter1.next() + "--");
        }
        System.out.println();
        //get all-values;
        Collection<String> values = map.values();
        Iterator iter2 = values.iterator();
        System.out.println("all-values:");
        while (iter2.hasNext()) {
            System.out.print(iter2.next() + "--");
        }

    }
}