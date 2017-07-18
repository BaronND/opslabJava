package JavaSE.collection.ListDemo;

import java.util.ArrayList;
import java.util.List;


public class getElement {

    public static void main(String[] args) {
        List<String> strList = null;
        strList = new ArrayList<String>();


        strList.add("hello");
        strList.add("hella");
        strList.add("hellb");
        strList.add("hellc");
        strList.add("helld");
        strList.add("helle");
        strList.add("hellf");

        //正序遍历
        for (int i = 0; i < strList.size(); i++) {
            System.out.print(strList.get(i) + "\t");
        }
        System.out.println();
        //逆序遍历
        for (int i = strList.size(); i > 0; i--) {
            System.out.print(strList.get(i - 1) + "\t");
        }
    }

}
