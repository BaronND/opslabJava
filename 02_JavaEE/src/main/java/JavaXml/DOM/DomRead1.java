package JavaXml.DOM;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomRead1 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        //利用DOM解析XML的一般步骤
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder build = null;
        try {
            build = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //获取Document对象
        Document doc = null;
        try {
            doc = build.parse("src/JavaXml/xml/DomRead1.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        //查找name节点
        NodeList nameList = doc.getElementsByTagName("name");
        //输出nameList下的第一个子节点的文本内容
        System.out.println(nameList.item(0).getFirstChild().getNodeValue());

    }

}
