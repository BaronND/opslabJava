package JavaSE.oop;

/************************************
 *
 * @summary 演示在继承关系中发生的覆写
 ***********************************/
class Persona {
    public String name;

    public void say() {
        System.out.println(name);
    }
}

class students extends Persona {
    public void say() {
        System.out.println(name + " and i am a student");
    }
}

public class overwrite {

    public static void main(String[] args) {
        students obj = new students();
        obj.name = "aa";
        obj.say();
    }
}

