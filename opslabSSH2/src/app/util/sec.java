package app.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class sec {
	/**
	 * 字符串加密函数MD5实现
	 */
	public static String md5(String password){
		MessageDigest md;   
		   try {   
		    // 生成一个MD5加密计算摘要   
		    md = MessageDigest.getInstance("MD5");   
		    // 计算md5函数   
		    md.update(password.getBytes());   
		    // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符   
		    // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值   
		    String pwd = new BigInteger(1, md.digest()).toString(16);   
		    return pwd;   
		   } catch (Exception e) {   
		    e.printStackTrace();   
		   }   
		   return password;   
	}
	
	/**
	 * 校验客户端传输过来的Id的有效性
	 * 此处简单的将其转为一个整数
	 */
	public static boolean isSec(String id){
		boolean r = false;
		try{
			Integer.parseInt(id);
			r = true;
		}catch(Exception e){
			e.printStackTrace();
			r = false;
		}
		return r;
	}
}
