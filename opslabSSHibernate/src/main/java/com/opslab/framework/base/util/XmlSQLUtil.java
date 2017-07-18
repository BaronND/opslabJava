package com.opslab.framework.base.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义从XML获取SQL查询语句和查询条件的接口
 */
public interface XmlSQLUtil {

    /**
     * 从XML配置文件获取查询语句
     * @param queryName
     * @return
     */
    String queryName(String queryName);

    /**
     * 从XML配置中获取查询条件
     * @param queryString
     * @return
     */
    String queryString(String queryString);
}
