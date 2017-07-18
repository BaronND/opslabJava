package JavaIO.External;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {

    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public void readExternal(ObjectInput arg0) throws IOException,
            ClassNotFoundException {
        //读取name和age属性
        this.name = (String) arg0.readObject();
        this.age = arg0.readInt();

    }

    @Override
    public void writeExternal(ObjectOutput arg0) throws IOException {
        //只写入name和age属性
        arg0.writeObject(name);
        arg0.writeInt(age);
    }


}
