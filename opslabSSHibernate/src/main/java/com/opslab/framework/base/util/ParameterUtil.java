package com.opslab.framework.base.util;

import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 处理http请求参数的工具类
 */
public class ParameterUtil {
    /**
     * 将Map<String, String[]>类型的请求参数转换为Map<String,Object>的参数
     * @param requst
     * @return
     */
    public static Map<String,Object> params(HttpServletRequest requst){
        Map<String,Object> param = new HashMap();
        Map<String, String[]> parameterMap = requst.getParameterMap();
        if(parameterMap != null && parameterMap.size() > 0){
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                String key = entry.getKey();
                String[] value = entry.getValue();
                if(value != null){
                    if(value.length == 1 && !"".equals(value[0])){
                        param.put(key,value[0]);
                    }else if(value.length > 1){
                        param.put(key,value);
                    }
                }
            }
        }
        return param;
    }

    public static void putModel(ModelMap model,Map<String,Object> param){
        if(param != null && param.size() > 0){
            for(Map.Entry<String,Object> entry:param.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                if(value != null){
                    if(value.getClass().isArray()){
                        model.put(key,value);
                    }else{
                        if(!"".equals(value)){
                            model.put(key,value);
                        }
                    }
                }
            }
        }
    }
}
