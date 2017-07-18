package JavaSE.collection.Linked;

import java.util.LinkedList;

/**
 * @author 禅师
 * @reusme 几种找到链表头的方法的比较
 */
public class getHeader {

    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<String>();

        link.add("A");
        link.add("B");
        link.add("C");
        link.add("D");

        System.out.println("1-1：使用element方法找到链表头元素:" + link.element());
        System.out.println("--：当前链表内容为:" + link);
        System.out.println("2-1：使用	peek方法找到链表头元素:" + link.peek());
        System.out.println("--：当前链表内容为:" + link);
        System.out.println("3-1：使用	poll方法找到链表头元素:" + link.poll());
        System.out.println("--：当前链表内容为:" + link);


    }

}
