package JavaXml.DOM4J;

import java.io.File;
import java.io.FileOutputStream;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jWrite {

    public static void main(String[] args) {

        //创建文档节点
        Document doc = DocumentHelper.createDocument();


        //创建节点
        Element Persons = doc.addElement("Persons");
        Element Person = Persons.addElement("Person");
        Element name = Person.addElement("name");
        Element email = Person.addElement("email");

        //设置内容
        name.setText("禅师");
        email.setText("snake@163.com");

        //输出到文件中
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");

        try {
            XMLWriter out = new XMLWriter(new
                    FileOutputStream(new File("src/JavaXml/xml/Dom4jWrite.xml")));
            out.write(doc);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
