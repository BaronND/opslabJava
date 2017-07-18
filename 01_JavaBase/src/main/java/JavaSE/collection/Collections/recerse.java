package JavaSE.collection.Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 禅师
 * @resume 将集合的内容反转
 */
public class recerse {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //向集合中添加内容
        java.util.Collections.addAll(list, "和尚", "尼姑", "方丈", "禅师", "师太");

        //当前顺序
        System.out.println("list的当前顺序:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }

        //将内容反转
        java.util.Collections.reverse(list);
        System.out.println("\nlist的现在顺序:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }
    }

}
