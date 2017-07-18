package JavaSE.collection.Collections;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author 禅师
 * @resume 利用Collections工具类返回不可加入元素的集合
 */
public class getCollection {

    public static void main(String[] args) {

        //返回不可变的List
        List<String> list = Collections.emptyList();

        Set<String> set = Collections.emptySet();

        list.add("AA");

        set.add("BB");

    }

}
