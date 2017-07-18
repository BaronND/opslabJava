package jvm.classload.classLoader;

/**
 * ExtendedClassLoader对应的是sum.misc.Launcher$ExtClassLoader.它是扩展类加载器，它是用Java编写的。
 * 它负责加载JRE的扩展目录，（JAVA_HOME/jre/ext或者java.ext.dirs系统属性指定的）中的JAR包。
 * 这是为引入除Java核心类以外的新功能提供了一个标准机制.
 * 因为默认的扩展目录对所有从同一个JRE中启动的JVM都是通用的。所以放入这个目录中的JAR类包对所有的JVM和AppClassLoader都是可见的。
 * 
 */
public class ExtensionClassLoader {
	public static void main(String[] args){
		System.out.println(System.getProperty("java.ext.dirs"));
		
		ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
		System.out.println(extClassLoader.getClass());
	}
}
