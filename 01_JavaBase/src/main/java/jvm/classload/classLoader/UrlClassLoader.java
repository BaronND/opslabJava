package jvm.classload.classLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class UrlClassLoader {
		  
	    public static void main(String[] args) throws Exception {  
	        URL urls[] = new URL[1];  
	        urls[0] = new URL("file:e:/program/java/Api.jar");  
	        @SuppressWarnings("resource")
			URLClassLoader loader = new URLClassLoader(urls);  
	        //如果用于WEB应用，则需要使用以下构造方法  
	        //URLClassLoader loader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());  
	        Class<?> api = loader.loadClass("com.wogu.Api");  
	        Constructor<?> constructors[] = api.getDeclaredConstructors();  
	        Object obj = constructors[0].newInstance();  
	        Method method = api.getMethod("test");  
	        method.invoke(obj);  
	    }  
}
