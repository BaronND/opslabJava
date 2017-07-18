package JavaXml.JDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 * @author 禅师
 * @resume 生成XML文件
 */
public class JDOMWrite1 {

    public static void main(String[] args) {
        //建立元素
        Element Persons = new Element("Persons");
        Element Person = new Element("Person");
        Element name = new Element("name");
        Element email = new Element("email");
        //建立属性
        Attribute id = new Attribute("id", "admin");

        //什么一个文档对象
        Document doc = new Document(Persons);

        //为节点设置内容
        name.setAttribute(id);
        name.setText("禅师");
        email.setText("snake@163.com");

        //设置节点关系
        Person.addContent(name);
        Person.addContent(email);
        Persons.addContent(Person);

        //准备输出XML
        XMLOutputter out = new XMLOutputter();
        //设置输出属性
        out.setFormat(out.getFormat().setEncoding("UTF-8"));

        //指定输出位置
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File("src/JavaXml/xml/JDOMWrite.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //输出
        try {
            out.output(doc, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
