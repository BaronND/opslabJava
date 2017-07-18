package JavaReflect.demo;

/**
 * @resume 获取Class实例的三种方法
 * 1.通过Class.forName()
 * 2.通过Object.getClass()
 * 3.通过对象.class
 */

class Y {

}

public class getClassInstance {

    public static void main(String[] args) {
        Class<?> c1 = null;
        Class<?> c2 = null;
        Class<?> c3 = null;

        try {
            c1 = Class.forName("JavaReflect.demo.Y");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        c2 = (new Y()).getClass();

        c3 = Y.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
    }

}
