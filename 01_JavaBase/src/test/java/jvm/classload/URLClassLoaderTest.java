package jvm.classload;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @descirption 测试URLClassLoader的使用
 */
public class URLClassLoaderTest {

    @Test
    public void test_LocalFileSystem() {
        //将将测试的*.class文件放到c:/temp/*.class
        File libDir = new File("c:/temp");

        try {
            System.out.println(libDir.toURL());
            URLClassLoader loader =
                    new URLClassLoader(new URL[]{libDir.toURL()});
            Class cls = loader.loadClass("JavaSec.classLoader.TargetClass");
            Object obj = cls.newInstance();
            //调用TargetClass类的method方法
            Method xMethod = cls.getDeclaredMethod("method");
            xMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_HTTP() {
        try {
            //通过http服务器动态加载远程类
            URL[] url = new URL[]{new URL("http://localhost")};
            URLClassLoader loader = new URLClassLoader(url);
            Class cls = loader.loadClass("JavaSec.classLoader.TargetClass");
            Object obj = cls.newInstance();
            //调用TargetClass类的method方法
            Method xMethod = cls.getDeclaredMethod("method");
            xMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
