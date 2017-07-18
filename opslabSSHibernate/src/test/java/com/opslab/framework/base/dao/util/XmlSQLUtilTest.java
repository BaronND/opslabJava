package com.opslab.framework.base.dao.util;

import com.opslab.framework.base.util.XmlSQLUtil;
import com.opslab.framework.base.util.impl.CommonXmlSQLUtil;
import org.junit.Test;


public class XmlSQLUtilTest {

    @Test
    public void testQuery(){

        XmlSQLUtil xmlSQLUtil = new CommonXmlSQLUtil();
        String queryName = "list";
        String queryString = xmlSQLUtil.queryName(queryName);
        System.out.println(queryString);

    }
}