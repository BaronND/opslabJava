package JavaSE.collection.ListDemo;

import java.util.ArrayList;
import java.util.List;

public class demo {


    public static void main(String[] args) {
        List<String> strList = null;
        strList = new ArrayList<String>();

        if (!(strList.isEmpty())) {
            System.out.println("当前内容为:" + strList);
        } else {
            System.out.println("当前为空");
        }

        strList.add("hello");
        strList.add("禅师");
        strList.add("尼姑");
        strList.add("方丈");
        strList.add("和尚");

        System.out.println(strList.contains("和尚") ? "有和尚这个元素" : "没有和尚这个元素");

        System.out.println("index [1~3]:" + strList.subList(1, 3));

    }

}
