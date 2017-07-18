package JavaSE.collection.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class demo1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("hello");
        list.add("hellA");
        list.add("hellB");
        list.add("hellC");
        list.add("hellD");
        list.add("hellE");


        //实例化Iterator输出接口实例
        Iterator<String> Iter = null;
        Iter = list.iterator();

        //使用Iterator实例迭代输出List集合
        while (Iter.hasNext()) {
            System.out.print(Iter.next() + "\t");
        }
    }

}
