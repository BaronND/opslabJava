package JavaSE.collection.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class addElements {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        //利用Collections工具类向list添加一组元素
        java.util.Collections.addAll(list, "和尚", "尼姑", "方丈", "禅师", "师太");

        Iterator<String> Iter = list.iterator();
        while (Iter.hasNext()) {
            System.out.print(Iter.next() + "\t");
        }
    }

}
