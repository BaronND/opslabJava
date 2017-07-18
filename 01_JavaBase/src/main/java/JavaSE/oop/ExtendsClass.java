package JavaSE.oop;

/*********************************************
 *
 * @summary 演示类的继承
 *********************************************/

class Persons {

    public String name;

    public int age;

    public String say() {
        return "I'am " + name + " and I was " + age + " years old";
    }

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Persons() {
    }

}

class student extends Persons {

    public String grade;

    public student() {
        super();
    }

    public student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void call() {
        System.out.println(super.say() + " " + this.grade + "  grade");
    }
}

public class ExtendsClass {
    public static void main(String[] args) {
        student am = new student("TM", 10, "3");
        am.call();
    }
}


