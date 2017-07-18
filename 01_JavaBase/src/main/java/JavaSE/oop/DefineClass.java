package JavaSE.oop;

/******************************************
 *
 * @summary 演示如何定义一个类
 */

class Person {

    public String name;

    public void say() {
        System.out.print("Hello I'am " + name);
    }


}

public class DefineClass {

    public static void main(String[] args) {
        Person man = new Person();
        man.name = "snake";
        man.say();
    }

}


