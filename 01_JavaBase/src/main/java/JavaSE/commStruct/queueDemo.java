package JavaSE.commStruct;

import java.util.LinkedList;

public class queueDemo {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<String>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println("Init-queue:" + queue);
        for (int i = 0; i <= queue.size() + 1; i++) {
            System.out.println(queue.poll());
        }
    }
}
