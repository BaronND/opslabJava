package JavaSE.collection.ListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 禅师
 * @resume 将集合转换为对象数组
 */
public class toArray {

    public static void main(String[] args) {
        List<String> strList = null;
        strList = new ArrayList<String>();

        strList.add("A");
        strList.add("T");
        strList.add("H");
        strList.add("L");
        strList.add("K");
        strList.add("B");
        strList.add("D");
        strList.add("E");
        strList.add("O");

        System.out.println("直接输入集合：" + strList);
        String str[] = null;
        //指定泛型的类型
        str = strList.toArray(new String[]{});
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + "\t");
        }
        System.out.println();
        Object temp[] = strList.toArray();
        for (int i = 0; i < temp.length; i++) {
            String c = (String) temp[i];
            System.out.print(c + "\t");
        }
    }

}
