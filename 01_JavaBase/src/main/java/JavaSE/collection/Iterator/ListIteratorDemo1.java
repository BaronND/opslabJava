package JavaSE.collection.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo1 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        ListIterator<String> listIter = null;

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        listIter = list.listIterator();

        //从前向后迭代
        System.out.println("从前向后迭代:");
        while (listIter.hasNext()) {
            String str = listIter.next();
            System.out.print(str + "\t");
        }

        //从后向前迭代
        System.out.println("\n从后向前迭代");
        while (listIter.hasPrevious()) {
            String str = listIter.previous();
            System.out.print(str + "\t");
        }
    }

}
