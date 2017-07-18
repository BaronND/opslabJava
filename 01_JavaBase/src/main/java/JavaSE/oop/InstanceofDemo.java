package JavaSE.oop;

/**************************************************
 *
 * @summary 演示Java的instanceof关键字
 **************************************************/

class A {
    public void fun1() {
        System.out.println("this's [Class A].fun1 ");
    }

    public void fun2() {
        System.out.println("this's [Class A].fun2 ");
    }
}

class B extends A {

    @Override
    public void fun1() {
        System.out.println("this's [Class B].fun1 ");
    }

    public void fun3() {
        System.out.println("this's [Class B].fun3 ");
    }
}

public class InstanceofDemo {
    public static void main(String[] args) {
        A a1 = new B();
        System.out.println("A a1 = new B();  a1 instanceof A?" + (a1 instanceof A));
        System.out.println("A a1 = new B();  a1 instanceof B?" + (a1 instanceof B));

        A a2 = new A();
        System.out.println("A a2 = new A();  a2 instanceof A?" + (a2 instanceof A));
        System.out.println("A a2 = new A();  a2 instanceof B?" + (a2 instanceof B));
    }
}
