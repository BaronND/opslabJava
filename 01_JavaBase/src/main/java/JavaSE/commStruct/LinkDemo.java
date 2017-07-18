package JavaSE.commStruct;

import java.util.LinkedList;

public class LinkDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();
        link.add("a");
        link.add("b");
        link.add("c");
        System.out.println("Init-link:" + link);

        link.addFirst("X");
        link.addLast("Y");
        System.out.println("Insert element:" + link);

        System.out.println("Link-header:" + link.element());
        System.out.println("find Link-header and delete:" + link.peek());
        System.out.println(link);
        System.out.println("find Link-header and do't delete:" + link.poll());
        System.out.println(link);


    }
}