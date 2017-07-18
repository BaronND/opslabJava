package JavaSE.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo1 {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("hello");
        all.add("Cs");
        all.add("world");

        Iterator<String> iter = all.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if ("Cs".equals(str)) {
                iter.remove();
            } else {
                System.out.print(str);
            }
        }
        //杈揿嚭板嗗悎鍐呭,璋幂敤toString()鏂规硶
        System.out.println(all);
    }
}