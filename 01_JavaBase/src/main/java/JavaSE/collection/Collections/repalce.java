package JavaSE.collection.Collections;

import java.util.ArrayList;
import java.util.List;

public class repalce {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //向集合中添加内容
        java.util.Collections.addAll(list, "和尚", "尼姑", "方丈", "禅师", "师太");

        //当前内容
        System.out.println("list的当前内容:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }


        //将里面的尼姑替换成小妮
        java.util.Collections.replaceAll(list, "尼姑", "小妮");
        System.out.println("\n替换后的List:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }
    }

}
