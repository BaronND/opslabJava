package JavaSE.collection.ListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 禅师
 * @resume 建立一个集合实例，并向其添加内容
 */
public class Add {

    public static void main(String[] args) {

        //通过ArrayList子类实例化List对象
        List<String> strList = new ArrayList<String>();

        //向集合中添加一个字符串
        strList.add("hello");
        strList.add(0, "禅师");
        System.out.println(strList);


        List<String> newList = new ArrayList<String>();
        newList.add("hello");
        newList.add("禅师");
        newList.add("hello");
        //添加一组对象
        newList.addAll(strList);
        System.out.println(newList);
    }

}
