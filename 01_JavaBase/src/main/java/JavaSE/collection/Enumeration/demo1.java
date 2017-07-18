package JavaSE.collection.Enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author 禅师
 * @resume 使用Enumeration输出集合
 */
public class demo1 {

    public static void main(String[] args) {

        Vector<String> list = new Vector<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //Instance Enumeration object
        Enumeration<String> enumer = list.elements();
        while (enumer.hasMoreElements()) {
            System.out.print(enumer.nextElement() + "\t");
        }

    }

}
