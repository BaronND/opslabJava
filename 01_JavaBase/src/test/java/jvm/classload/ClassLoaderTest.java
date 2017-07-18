package jvm.classload;

import java.util.Date;

class test{
	
}
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception{
		
		//每个class都包含一个对应的Classloader的引用
		//当然Java基础类型的getClassLoader返回为null
		String strs = "string";
		System.out.println(strs.getClass().getClassLoader());
		
		System.out.println(System.class.getClassLoader());
		
		System.out.println(Integer.class.getClassLoader());
		
		System.out.println(Date.class.getClassLoader());
		
	}
}
