package com.opslab.framework.base.util.impl;


import com.opslab.framework.base.util.XmlSQLUtil;
import com.opslab.util.ConfigUtil;
import com.opslab.util.FileUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 实现一个普通的XMLSQLUtil
 * 不带缓存
 */
public class CommonXmlSQLUtil implements XmlSQLUtil {

    private static Logger logger = Logger.getLogger(CommonXmlSQLUtil.class);



    private String config_dir ="";

    public CommonXmlSQLUtil()  {

        String temp = "db.properties";
        String classpath = ConfigUtil.resourcePath(temp).replace(temp, "");
        config_dir = (classpath + "sql/").replaceAll("\\\\","/");
        logger.debug("list config files:" + config_dir);


    }

    /**
     * 解析xml
     *
     * @param xml
     * @return
     */
    private static Map<String, String> parseXML(File xml) {
        Map<String, String> map = new HashMap<>();
        //建立SAX解析器
        SAXReader read = new SAXReader();
        //导入XML文件
        Document doc = null;
        try {
            doc = read.read(xml);
        } catch (DocumentException e) {
            logger.error("parse xml error " + xml.getPath() + ":" + e.getMessage());
        }
        Element root = doc.getRootElement();
        //取得全部的Person节点
        Iterator<?> iter = root.elementIterator("query");
        while (iter.hasNext()) {
            Element temp = (Element) iter.next();
            String name = temp.attributeValue("name");
            String query = temp.elementText("queryString");
            map.put(name, query);
        }
        return map;
    }

    /**
     * 此处先每次从配置文件中加载
     * 便于程序开发
     * @param queryName
     * @return
     */
    @Override
    public String queryName(String queryName) {
        Map<String, String> map = new HashMap<>();
        List<File> files = FileUtil.listFileFilter(new File(config_dir), ".xml");
        for (File file : files) {
            map.putAll(parseXML(file));
        }
        return map.get(queryName).replaceAll("\\n","").trim();
    }

    @Override
    public String queryString(String queryString) {
        return null;
    }
}
