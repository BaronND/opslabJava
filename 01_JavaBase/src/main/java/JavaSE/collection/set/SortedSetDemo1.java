package JavaSE.collection.set;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo1 {
    public static void main(String[] args) {

        SortedSet<String> set = new TreeSet<String>();

        set.add("F");
        set.add("E");
        set.add("F");
        set.add("A");
        set.add("D");
        set.add("H");
        set.add("B");
        set.add("D");
        set.add("C");
        set.add("A");
        set.add("H");
        System.out.println(set);

        System.out.println("第一个元素为 ：" + set.first());
        System.out.println("最后一个元素为 ：" + set.last());
        System.out.println("最后一个元素为 ：" + set.last());
        System.out.println("D元素前的元素：" + set.headSet("D"));
        System.out.println("D元素后的元素：" + set.tailSet("D"));
        System.out.println("C到F之间的元素" + set.subSet("C", "F"));

    }

}
