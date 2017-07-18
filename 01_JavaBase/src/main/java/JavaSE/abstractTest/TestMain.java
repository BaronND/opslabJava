package JavaSE.abstractTest;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("不实例化抽象类,访问抽象类中的静态成员属性->" + AbstractClass.str);

        System.out.println("不实现抽象类,调用抽象类中的静态方法->" + AbstractClass.method());
    }

}
