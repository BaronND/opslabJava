package com.opslab.util;

/**
 * 比例相关的工具类
 */
public class RatioUtil {
    /**
     * 换算一个比例小树保留9位
     *
     * @param element
     * @param denominator
     * @return
     */
    public static double toDouble(int element, int denominator) {
        double ratio = (double) element / denominator;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.000000000");
        return Double.parseDouble(df.format(ratio));
    }
}
