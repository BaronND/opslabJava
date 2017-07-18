package JavaXml.DOM4J;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @summary: 测试通过Schema指定的默认值固定值
 */
public class ReadSchemaDefaultValue {
    public static void main(String[] args) {
        String xmlPath = "E:/workspace/J2EE/J2EE/WebContent/xml/base_schema_simpleElement.xml";

        //建立SAX解析器
        SAXReader read = new SAXReader();

        //导入XML文件
        Document doc = null;

        try {
            doc = read.read(new File(xmlPath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //获取根元素
        Element root = doc.getRootElement();
        Iterator<?> iter = root.elements().iterator();
        while (iter.hasNext()) {
            Element temp = (Element) iter.next();
            System.out.println(temp.asXML());
        }
    }
}
