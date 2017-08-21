package entity;

/**
 * Created by wuyanbing on 2017/8/16 0016.
 */
public class Person {
    private String kid;
    private String name;
    private int age;

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String kid, String name, int age) {
        this.kid = kid;
        this.name = name;
        this.age = age;
    }
}
