package JavaSE.collection.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class demo2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();


        list.add("A");
        list.add("_");
        list.add("B");
        list.add("_");
        list.add("C");
        list.add("_");
        list.add("D");
        Iterator<String> iter = list.iterator();

        System.out.println("初始化的List为" + list);
        while (iter.hasNext()) {
            String str = iter.next();
            if ("_".equals(str)) {
                iter.remove();
            } else {
                System.out.print(str + "\t");
            }
        }
        System.out.println("\n输出并删除有的list为" + list);

    }

}
