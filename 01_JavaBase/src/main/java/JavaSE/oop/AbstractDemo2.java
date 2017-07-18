package JavaSE.oop;

public class AbstractDemo2 extends InnerClass {

    @Override
    public void printA() {
        System.out.println("this function is defined in InnerClass");
    }

    class Y implements A {

        @Override
        public void printB() {
            System.out.println("this function is defined in "
                    + "InnerClass and is interface-function");
        }
    }

    public static void main(String[] args) {
        AbstractDemo2 obj = new AbstractDemo2();
        obj.printA();

        A I_obj = new AbstractDemo2().new Y();
        I_obj.printB();
    }
}

abstract class InnerClass {
    public abstract void printA();

    interface A {
        public void printB();
    }
}

