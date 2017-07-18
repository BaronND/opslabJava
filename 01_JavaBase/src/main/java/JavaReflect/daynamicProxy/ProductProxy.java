package JavaReflect.daynamicProxy;

import java.lang.reflect.Proxy;

public class ProductProxy {

    /**
     * 返回一个动态代理的对象
     *
     * @param obj
     * @return
     */
    public static Product newInstance(Object obj) {

        return (Product) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(), //需要代理对象的类加载器
                obj.getClass().getInterfaces(), //需要代理的接口
                new MyInvocationHandler(obj)    //自定义的拦截器
        );
    }
}
