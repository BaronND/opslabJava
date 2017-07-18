package com.opslab.workflow.util;
/**
 * 字符串工具类
 */
public class StringUtil {
	/**
	 * 将字符串转换成数组,按照tag分割
	 */
	public static String[] str2Arr(String str,String tag){
		if(str != null && str.length() > 0){
			return str.split(tag);
		}
		return null ;
	}

	/**
	 * 判断在values数组中是否含有指定value字符串
	 */
	public static boolean contains(String[] values, String value) {
		if(values != null && values.length > 0){
			for(String s : values){
				if(s.equals(value)){
					return true ;
				}
			}
		}
		return false;
	}

	/**
	 * 将数组变换成字符串,使用","号分割
	 */
	public static String arr2Str(Object[] arr) {
		String temp = "" ;
		if(arr != null && arr.length > 0){
			for(Object s : arr){
				temp = temp + String.valueOf(s) + "," ;
			}
			return temp.substring(0,temp.length() - 1);
		}
		return temp;
	}
}
