package jvm.classload.classLoader;

/**
 * 
 * @description
 * 		用来动态加载的类
 */
public class TargetClass {
	public TargetClass(){
		System.out.println("I will be born");
	}
	
	public void method(){
		System.out.println("I can!");
	}
}
