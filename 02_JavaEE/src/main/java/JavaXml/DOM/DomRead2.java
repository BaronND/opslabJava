package JavaXml.DOM;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomRead2 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //DOM解析一般格式
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder build = null;
        Document doc = null;

        build = factory.newDocumentBuilder();
        doc = build.parse("src/JavaXml/xml/DomRead2.xml");


        //获得person列表
        NodeList persons = doc.getElementsByTagName("person");
        //循环输出内容
        for (int i = 0; i < persons.getLength(); i++) {
            Element e = (Element) persons.item(i);

            System.out.println("姓名:" + e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
            System.out.println("邮箱:" + e.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
        }

    }

}
