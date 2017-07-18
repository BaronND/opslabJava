package JavaSE.collection.properites;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class demo2 {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties pro = new Properties();

        pro.setProperty("QH", "青海");
        pro.setProperty("XN", "西宁");

        System.out.println("key : value -> QH : " + pro.getProperty("QH"));
        System.out.println("key : value -> XN : " + pro.getProperty("XN"));

        File file = new File("C:\\1.properties");
        pro.store(new FileOutputStream(file), "属性文件");

    }

}
