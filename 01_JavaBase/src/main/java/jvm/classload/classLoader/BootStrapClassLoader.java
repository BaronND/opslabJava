package jvm.classload.classLoader;

import java.net.URL;

/**
 * BootStrap ClassLoader：称为启动类加载器，是Java类加载层次中最顶层的类加载器，
 * 负责加载JDK中的核心类库，如：rt.jar、resources.jar、charsets.jar等
 * 
 */
public class BootStrapClassLoader {
	public static void main(String[] args) {
		/*
		 * 罗列当前程序所加载的JDK
		 */
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}

		//也可以通过sun.boot.class.path环境变了获取
		System.out.println(System.getProperty("sun.boot.class.path"));
	}
}
