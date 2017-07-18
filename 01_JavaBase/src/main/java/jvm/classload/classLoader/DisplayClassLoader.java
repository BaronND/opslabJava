package jvm.classload.classLoader;
/**
 * 演示显示加载
 */

class TestClass{
		
	public void method(){
		System.out.println(this.getClass()+"::method");
	}
	
}
public class DisplayClassLoader {
	public static void main(String[] args){
		//显示加载类 可以用class.forName()或自己实现的ClassLoader
		try {
			Class<?> c = Class.forName("JavaSec.classLoader.TestClass");
			try {
				TestClass obj = (TestClass) c.newInstance();
				obj.method();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
