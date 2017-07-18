package JavaReflect.daynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    private Long startTime;

    private Long endTime;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }


    /**
     * @summary: 在调用目标对象的方法前，调用该方法。横向加入自己的代码，这就是AOP的编程思想
     */
    public void beforeMethod(Method method) {
        startTime = System.currentTimeMillis();
        System.out.println(obj.getClass().getName() + "::" + method.getName() + " is called::start");
    }

    public void afterMethod(Method method) {
        endTime = System.currentTimeMillis();
        System.out.println(obj.getClass().getName() + "::" + method.getName() + " is called::end::" + (endTime - startTime));
    }


    /**
     * 在调用目标类的方法时添加上自己的方法。类似HOOK技术
     * <p>
     * proxy:实例对象的代理对象$Proxy0
     * method:调用的目标方法
     * args：调用目标方法的需要的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        beforeMethod(method);

        Object result = null;

        try {
            System.out.println(proxy.getClass());
            result = method.invoke(obj, args);
        } catch (Exception e) {
            //log.error(e.getMessage())
            e.printStackTrace();
        }

        afterMethod(method);
        return result;
    }

}
