package JavaSE.collection.Collections;

import java.util.ArrayList;
import java.util.List;

public class swap {
    //内容位置的调换
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        //向集合中添加内容
        java.util.Collections.addAll(list, "和尚", "尼姑", "方丈", "禅师", "师太");

        //当前内容
        System.out.println("list的当前内容:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }
        //将禅师和师太的位置调转
        java.util.Collections.swap(list, 3, 4);
        System.out.println("\n现在的list：");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }
    }

}
