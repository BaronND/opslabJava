package JavaSE.collection.properites;

import java.util.Properties;

/*
 * 设置个读取数序
 */
public class demo1 {

    public static void main(String[] args) {
        Properties pro = new Properties();

        pro.setProperty("QH", "青海");
        pro.setProperty("XN", "西宁");

        System.out.println("key : value -> QH : " + pro.getProperty("QH"));
        System.out.println("key : value -> XN : " + pro.getProperty("XN"));

    }

}
