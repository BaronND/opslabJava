package com.opslab.imagemanager.util;

/**
 * 单位转换
 */
public class UnitUtil {

    /**
     * bit转换为MB
     * @param b
     * @return
     */
    public static int B2M(int b){
        return b/(1024 * 1024);
    }
}
