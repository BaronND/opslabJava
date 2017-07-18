package JavaXml.JDOM;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * @author 禅师
 * @resume 利用JDOM读取xml\JDOMRead1.xml
 */
public class JDOMRead1 {

    public static void main(String[] args) throws JDOMException, IOException {

        //建立SAX解析引擎
        SAXBuilder build = new SAXBuilder();
        Document doc = null;
        doc = build.build("src/JavaXml/xml/JDOMRead1.xml");


        //取得根元素
        Element root = doc.getRootElement();

        //获得Person子节点
        List<Element> list = root.getChild("one").getChildren("Person");
        for (int i = 0; i < list.size(); i++) {
            Element temp = (Element) list.get(i);
            String name = temp.getChildText("name");
            String email = temp.getChildText("email");
            System.out.println("name :" + name + "\temail:" + email);
        }


    }

}
