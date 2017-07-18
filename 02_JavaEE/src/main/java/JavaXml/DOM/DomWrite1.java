package JavaXml.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author 禅师
 * @resume 生成xml文件
 * <p>
 * xml\DomWrite1.xml
 * <?xml version="1.0" encoding="UTF-8"?>
 * <p>
 * <person>
 * <name>禅师</name>
 * </person>
 */
public class DomWrite1 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = null;
        Document doc = null;

        try {
            build = factory.newDocumentBuilder();
            doc = build.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //建立各个节点
        Element Person = doc.createElement("person");
        Element name = doc.createElement("name");
        //设置节点的内容
        name.appendChild(doc.createTextNode("禅师"));

        //设置节点关系
        Person.appendChild(name);
        doc.appendChild(Person);


        //输出XML
        TransformerFactory tfactory = TransformerFactory.newInstance();
        Transformer tformer = null;

        DOMSource source = new DOMSource(doc);

        try {
            tformer = tfactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        tformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

        //设置输出位置
        StreamResult result = new StreamResult(new File("src/JavaXml/xml/DomWrite1.xml"));


        //执行输出
        try {
            tformer.transform(source, result);
        } catch (TransformerException e) {
            System.out.println("输出xml文件异常");
            e.printStackTrace();
        }

    }

}
