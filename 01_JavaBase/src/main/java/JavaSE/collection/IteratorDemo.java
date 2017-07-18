package JavaSE.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("program");

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "\t");
        }
    }
}