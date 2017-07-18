package JavaXml.DOM4J;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jReadBoolean {
    public static void main(String[] args) {
        File file = new File("src/JavaXml/xml/Dom4jReadBoolean.xml");

        // 建立SAX解析器
        SAXReader read = new SAXReader();

        // 导入XML文件
        Document doc = null;

        try {
            doc = read.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // 获取根元素
        Element root = doc.getRootElement();

        // 取得全部的Person节点
        Iterator<?> iter = root.elementIterator("Person");
        while (iter.hasNext()) {
            Element temp = (Element) iter.next();
            String name = temp.elementText("name");
            String email = temp.elementText("email");
            System.out.println(temp.elementText("boolean"));
        }
    }
}
