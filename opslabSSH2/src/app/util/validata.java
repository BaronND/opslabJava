package app.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.constant.constant;

public class validata {
	
	/**
	 * 判断字符串有效性
	 */
	public static boolean isValid(String src){
		return !(src == null || "".equals(src.trim()));
	}
	
	/**
	 * 判断集合的有效性 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col){
		return !(col == null || col.isEmpty());
	}
	
	/**
	 * 判断数组是否有效
	 */
	public static boolean isValid(Object[] arr){
		return !(arr==null || arr.length==0);
	}
	
	/**
	 * 判断是否是一个有效的邮箱地址
	 */
	public static boolean isEmail(String email){
		Pattern p =  Pattern.compile(constant.REG_EMAIL);
        Matcher m = p.matcher(email);  
        return m.matches();  
	}
}
