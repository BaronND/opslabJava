package JavaSE.collection.Linked;

/**
 * 模拟链表
 */

import java.util.LinkedList;

public class demo1 {

    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();

        link.add("A");
        link.add("B");
        link.add("C");
        System.out.println("链表初始化完成:" + link);

        //在连标题头插入X
        link.addFirst("X");
        //在链表结尾插入Y
        link.addLast("Y");
        System.out.println("新链表为：" + link);

        System.exit(0);
    }

}
