package com.opslab.blog.util;

import com.opslab.blog.admin.domain.GeneralCode;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
public class PackageUtil {
    /**
     * 返回Mapper配置的包命名
     * @param t
     * @return
     */
    public static String mapperPackage(Class t){
        return t.getName()+".";
    }


    ////////////////
    //test
    public static void main(String[] args){
        System.out.println(mapperPackage(GeneralCode.class));
    }
}
