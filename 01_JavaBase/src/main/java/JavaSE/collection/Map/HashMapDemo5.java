package JavaSE.collection.Map;

import java.util.HashMap;
import java.util.Map;


class Person {
    private String name;

    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", sex=" + sex + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}

public class HashMapDemo5 {
    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<String, Person>();

        Person p = new Person("测试", "男");
        map.put(p.getName(), p);
        for (String k : map.keySet()) {
            System.out.println(map.get(k));
        }
        //修改后看看Map中的值能否跟着变
        p.setSex("未知");
        for (String k : map.keySet()) {
            System.out.println(map.get(k));
        }
    }
}
