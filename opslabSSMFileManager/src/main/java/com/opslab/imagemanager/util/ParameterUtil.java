package com.opslab.imagemanager.util;

import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于处理http请求参数
 */
public class ParameterUtil {
    /**
     * 将Map<String, String[]>类型的请求参数转换为Map<String,Object>的参数
     * @param requst
     * @return
     */
    public static Map<Object,Object> params(HttpServletRequest requst){
        Map<Object,Object> param = new HashMap();
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

    public static void putModel(ModelMap model, Map<Object,Object> param){
        if(param == null || param.size() == 0){
            return;
        }
        for(Map.Entry<Object,Object> entry:param.entrySet()){
            String key = (String)entry.getKey();
            Object value = entry.getValue();
            if(value != null){
                if(value.getClass().isArray()){
                    model.put(key,value);
                }else{
                    if(!"".equals(value)){
                        model.put(key,(String)value);
                    }
                }
            }
        }
    }
}
