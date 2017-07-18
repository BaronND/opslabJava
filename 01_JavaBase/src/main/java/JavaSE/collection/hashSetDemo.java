package JavaSE.collection;

import java.util.HashSet;
import java.util.Set;

public class hashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("B");
        set.add("E");
        set.add("A");
        set.add("A");
        set.add("A");
        set.add("D");
        set.add("C");
        System.out.println(set);
    }
}