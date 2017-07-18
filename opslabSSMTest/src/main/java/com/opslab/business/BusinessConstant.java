package com.opslab.business;

import com.opslab.util.ArrayUtil;
import com.opslab.util.RatioUtil;

/**
 * 业务相关的常量
 */
public final class BusinessConstant {
    /**
     * 双色球红球
     */
    public static final Integer[] RED_ARRAY =
            new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                    22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
    /**
     * 红球的默认比例
     */
    public static final Double[] RED_RATIO = ArrayUtil.newArray(RatioUtil.toDouble(1, 33), 33);
    /**
     * 双色球篮球
     */
    public static final Integer[] BLUE_ARRY =
            new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    /**
     * 蓝球的默认比例
     */
    public static final Double[] BLUE_RATIO = ArrayUtil.newArray(RatioUtil.toDouble(1, 16), 16);
}
