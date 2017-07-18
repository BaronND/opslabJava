package JavaSE.collection.ListDemo;

import java.util.ArrayList;
import java.util.List;

public class Remove {

    public static void main(String[] args) {
        List<String> strList = null;
        strList = new ArrayList<String>();

        strList.add("hello");
        strList.add(0, "world");
        strList.add("google");
        strList.add(1, "baidu");
        System.out.println(strList);

        strList.remove("world");
        strList.remove(1);
        System.out.println(strList);
    }

}
