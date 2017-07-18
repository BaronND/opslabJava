package JavaSE.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<String> all = new ArrayList<String>();
        all.add("hello");
        all.add("world");
        all.add("test");

        ListIterator<String> iter = all.listIterator();
        System.out.print("0 -> 1:");
        while (iter.hasNext()) {
            System.out.print(iter.next() + "~");
        }
        System.out.print("\n 1 -> 0:");
        while (iter.hasPrevious()) {
            System.out.print(iter.previous() + "~");
        }
    }
}