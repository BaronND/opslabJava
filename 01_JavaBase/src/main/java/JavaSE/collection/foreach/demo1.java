package JavaSE.collection.foreach;

import java.util.ArrayList;
import java.util.List;

public class demo1 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");

        //利用foreach迭代
        for (String str : list) {
            System.out.print(str + "\t");
        }
    }

}
