package JavaXml.validata;
/************************************************************
 * @summmary:
 * 		利用Java+DOM4J检验xml文档是否复合规范（DTD 和 schema）
 ***********************************************************/
 


/* 1、需要四个JAR包的支持：isorelax、dom4j、relaxngDatatype、xsdlib，都可以在sourceforge上面下载，如果不知道如何查找， 
 * 参看：http://blog.csdn.net/fenglibing/archive/2009/05/04/4149558.aspx 
 * 2、该程序实现的理论支论，参见文章：http://blog.csdn.net/fenglibing/archive/2009/05/05/4150510.aspx 
 * 3、如果想错误提示使用中文，可以使用Locale.setDefault(Locale.CHINA)来设置默认的Locale，
 * 同时在这个类的同一个包中增加Message_zh_CN.properties文件,
 * 这个文件将中文变成unicode. 可以使用jdk下的工具native2ascii来实现.native2ascii的使用介绍，参见如下文章： 
 * http://blog.csdn.net/fenglibing/archive/2009/05/04/4149680.aspx 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


//import org.iso_relax.verifier.Schema;
//import org.iso_relax.verifier.Verifier;
//import org.iso_relax.verifier.VerifierFactory;
//import org.iso_relax.verifier.VerifierFilter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class SchemaValidation {

    public static void main(String[] args) {
        validate();
    }

    public static void validate() {
//    	String xmlPath="E:/workspace/J2EE/J2EE/WebContent/xml/base_schema_03.xml";
//    	String xsdPath="E:/workspace/J2EE/J2EE/WebContent/xml/base_schema_03.xsd";
        String xmlPath = "E:/workspace/J2EE/J2EE/WebContent/xml/base_schema_01.xml";
        String xsdPath = "E:/workspace/J2EE/J2EE/WebContent/xml/base_schema_01.xsd";
        try {
            SchemaValidation demo = new SchemaValidation();
            // Give the xml and schema name  
            //InputStream xmlString = demo.getClass().getResourceAsStream(  
            //       "GBAInit.xml");
            //InputStream schemaStr = demo.getClass().getResourceAsStream(  
            //       "GBAInitSchema.xsd");
            InputStream xmlString = new FileInputStream(new File(xmlPath));
            InputStream schemaStr = new FileInputStream(new File(xsdPath));
            SAXReader reader = createSAXReader(schemaStr);
            System.out.println("XSD parse successfully !");

            Document document = reader.read(xmlString);
            System.out.println("Successfully validation .. . ");
        } catch (DocumentException e) {
            System.out.println("Exception occurred: " + e);
            Throwable nestedException = e.getNestedException();
            if (nestedException != null) {
                System.out.println("NestedException: " + nestedException);
                nestedException.printStackTrace();
            } else {
                e.printStackTrace();
            }
        } catch (Throwable t) {
            System.out.println("Exception occurred: " + t);
            t.printStackTrace();
        }
    }

    /**
     * Registers the Verifier with the SAXReader
     */
    protected static SAXReader createSAXReader(InputStream schemaURI)
            throws Exception {
//        //四步必须，一步可选：创建校验工厂、编码Schema、生成校验器、[设置错误处理]、XML文档校验
//        //第一步：创建校验工厂，可选择不同的校验工厂
//        // use autodetection of schemas
//        //查看JARV的详细信息：http://iso-relax.sourceforge.net/JARV/，进入其userGuide
//        //该步为创建校验工厂实例，如果需要换成其它的校验器，将com.sun.msv.verifier.jarv.TheFactoryImpl()换成其它即可，
//        // 如使用 Swift RELAX Verifier：
//        //VerifierFactory factory = new jp.xml.gr.relax.swift.SwiftVerifierFactory();
//        VerifierFactory factory = new com.sun.msv.verifier.jarv.TheFactoryImpl();
//        //第二步：编译成Schema，支持源为URL、InputStream、File、InputSource等
//        Schema schema = factory.compileSchema(schemaURI);
//        //第三步：生成校验器
//        Verifier verifier = schema.newVerifier();
//        //第四步：设置自己的错误处理，如果不设置就是默认的错误处理
//        verifier.setErrorHandler(new ErrorHandler() {
//            public void error(SAXParseException e) {
//                System.out.println("ERROR: " + e);
//            }
//
//            public void fatalError(SAXParseException e) {
//                System.out.println("FATAL: " + e);
//            }
//
//            public void warning(SAXParseException e) {
//                System.out.println("WARNING: " + e);
//            }
//        });
//        //第五步：XML文档校验
//        VerifierFilter filter = verifier.getVerifierFilter();
//        //默认SAXReader的校验是关闭的，采用setXMLFilter方法，就显示设置了过滤器，后面生成的对象就会做校验
        SAXReader reader = new SAXReader();
        //reader.setXMLFilter(filter);
        return reader;
    }
}  
