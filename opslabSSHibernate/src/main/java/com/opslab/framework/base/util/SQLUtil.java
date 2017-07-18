package com.opslab.framework.base.util;

import com.opslab.util.collection.CollectionUtil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SQL相关的工具类
 */
public class SQLUtil {
    public static synchronized Map<String,String> paramsConvert(Map<String,Object> params){
        Map<String,String> param = new LinkedHashMap();
        for(Map.Entry entry:params.entrySet()){
            param.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
        }
        return param;
    }
    public static String whereExpression(Map<String,String> whereExpression, Map<String,Object> params){
        StringBuffer sbuf = new StringBuffer();
        if(whereExpression != null && whereExpression.size() > 0 && params != null && params.size() > 0){
            Map<String, String> intersection = CollectionUtil.intersection(whereExpression,paramsConvert(params) );
            if(intersection != null && intersection.size() > 0){
                String where =  com.opslab.util.CollectionUtil.valueJoin(intersection," and ");
                sbuf.append(" where ");
                sbuf.append(where);
            }
        }
        return sbuf.toString();
    }
}
