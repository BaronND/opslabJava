package JavaSE.collection.Linked;

import java.util.LinkedList;

/**
 * @author 禅师
 * @resume 实现队列，及先进现出
 */
public class queue {

    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();

        link.add("A");
        link.add("B");
        link.add("C");
        link.add("D");
        System.out.println(link.size());
        int size = link.size();
        for (int i = 0; i < size; i++) {
            System.out.print(link.poll() + "\t");
        }

        System.out.println("\n最后的link" + link);

        System.exit(0);
    }

}
