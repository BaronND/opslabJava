package JavaSE.collection.Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 禅师
 * @resume 对内容排序并检索内容
 */
public class checkEle {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        //向集合中添加内容
        java.util.Collections.addAll(list, "和尚", "尼姑", "方丈", "禅师", "师太");

        //当前顺序
        System.out.println("list的当前顺序:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }

        //对数据进行排序
        java.util.Collections.sort(list);
        System.out.println("\n排序后的list:");
        for (String temp : list) {
            System.out.print(temp + "\t");
        }

        //查找禅师
        int i = java.util.Collections.binarySearch(list, "禅师");
        System.out.println("\n 禅师的索引为" + (i + 1));


    }

}
