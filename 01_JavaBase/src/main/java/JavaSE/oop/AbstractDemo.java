package JavaSE.oop;

/*****************************************************
 *
 * @summary 演示抽象类的使用
 ****************************************************/

abstract class ABdemo {
    public String info = "this is a abstract class";

    /*
     * define abstract class
     */
    public abstract void say();
}

class ABdemo_impl extends ABdemo {
    @Override
    public void say() {
        System.out.println("在子类中实现的抽象方法");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        ABdemo_impl obj = new ABdemo_impl();
        obj.say();
    }
}

