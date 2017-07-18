package com.opslab.util;


import java.util.*;

public class RandomUtil {
    public static final String ALLCHAR
            = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LETTERCHAR
            = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERCHAR
            = "0123456789";


    /**
     * 生成制定范围内的随机数
     *
     * @param scopeMin
     * @param scoeMax
     * @return
     */
    public static int integer(int scopeMin, int scoeMax) {
        Random random = new Random();
        return (random.nextInt(scoeMax) % (scoeMax - scopeMin + 1) + scopeMin);
    }


    /**
     * 从指定的数组中随机数组中的某个元素
     */
    public static <T> T randomItem(T[] param) {
        int index = integer(0, param.length);
        return param[index];
    }

    /**
     * 实现一个简单的字符串乘法
     *
     * @param str
     * @param multiplication
     * @return
     */
    private static String strMultiplication(String str, int multiplication) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < multiplication; i++) {
            buffer.append(str);
        }
        return buffer.toString();
    }

    /**
     * 从指定的数组中按照指定比例返回指定的随机元素
     *
     * @param param
     * @param percentum
     * @param <T>
     * @return
     */
    public static <T> T randomItem(T[] param, Double[] percentum) {
        int length = percentum.length;
        Integer[] ints = ArrayUtil.doubleBitCount(percentum);
        int max = Collections.max(Arrays.asList(ints));
        int[] arr = new int[length];
        int sum = 0;
        Map map = new HashMap(length);
        int multiple = Integer.parseInt("1" + strMultiplication("0", max));
        for (int i = 0; i < length; i++) {
            int temp = (int) (percentum[i] * multiple);
            arr[i] = temp;
            if (i == 0) {
                map.put(i, new int[]{1, temp});
            } else {
                map.put(i, new int[]{sum, sum + temp});
            }
            sum += temp;
        }
        int indexSum = integer(1, sum);
        int index = -1;
        for (int i = 0; i < length; i++) {
            int[] scope = (int[]) map.get(i);
            if (indexSum == 1) {
                index = 0;
                break;
            }
            if (indexSum > scope[0] && indexSum <= scope[1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("随机失败");
        } else {
            return param[index];
        }
    }


}
