package JavaSE.collection.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 禅师
 * @resume 验证treeSet对数据元素的排序
 */
public class TreeSetDemo1 {

    public static void main(String[] args) {
        Set<String> strSet = new TreeSet<String>();

        strSet.add("E");
        strSet.add("A");
        strSet.add("D");
        strSet.add("B");
        strSet.add("F");
        strSet.add("C");

        System.out.println(strSet);
    }

}
