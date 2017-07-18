package com.opslab.util;

import java.util.List;
import java.util.Map;

/**
 * 集合相关的工具类
 */
public class CollectionUtil {
    /**
     * 将map的value以separator链接并以字符串的形式返回
     * @param map
     * @param separator
     * @param <K>
     * @param <V>
     * @return
     */
    public final static <K,V> String valueJoin(Map<K,V> map, String separator){
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(String.valueOf(entry.getValue())).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - separator.length());
    }

    /**
     * 将List以separator链接并以字符串的形式返回
     * @param list
     * @param separator
     * @param <T>
     * @return
     */
    public final static <T> String join(List<T> list, String separator) {
        if(list == null || list.size() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toString()).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - separator.length());
    }
}
