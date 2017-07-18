package JavaSE.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 禅师
 * @resume 向HashSet中添加元素，验证Set集合不能添加重复值的特性
 */
public class HashSetdemo1 {


    public static void main(String[] args) {
        Set<String> strSet = new HashSet<String>();

        strSet.add("A");
        strSet.add("A");
        strSet.add("B");
        strSet.add("B");
        strSet.add("C");
        strSet.add("C");
        strSet.add("D");
        strSet.add("D");

        System.out.println(strSet);

        System.exit(0);
    }

}
