package com.opslab.blog.util;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
public class ArrayUtil {
    /**
     * 获取一个double类型的数字的小数位有多长
     * @param dd
     * @return
     */
    public static int doueleBitCount(double dd){
        String temp = String.valueOf(dd);
        int i = temp.indexOf(".");
        if(i > -1){
            return temp.length()-i -1;
        }
        return 0;

    }

    public static Integer[] doubleBitCount(double[] arr){
        Integer[] len = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = doueleBitCount(arr[i]);
        }
        return len;
    }



    public static Integer[] doubleBitCount(Double[] arr){
        Integer[] len = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = doueleBitCount(arr[i]);
        }
        return len;
    }

    /**
     * 以某人值创建一个数组
     */
    public static  Double[] newArray(Double t,int length){
        Double[] doubles =   new Double[length];
        for (int i = 0; i < length; i++) {
            doubles[i] = t;
        }
        return doubles;
    }

    public static Integer[] doubleBit(double[] arr){
        Integer[] len = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = doueleBitCount(arr[i]);
        }
        return len;
    }
}
