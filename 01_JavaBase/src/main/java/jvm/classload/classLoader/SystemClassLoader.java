package jvm.classload.classLoader;

public class SystemClassLoader {
	public static void main(String[] args){
		System.out.println(System.getProperty("java.class.path"));
		ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(appClassLoader.getClass());
	}
}
