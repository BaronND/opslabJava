package JavaSE.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Student)) {
            if (this == obj) {
                return true;
            } else {
                Student stu = (Student) obj;
                if (stu.name.equals(this.name) && stu.age == this.age) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public String toString() {
        return "name:" + this.name + "\t\tage:" + this.age;
    }

    //setter and getter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class StudentComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {//指定排序规则,即按年龄排序
        if (s1.equals(s2)) {
            return 0;
        } else if (s1.getAge() < s2.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class compare1 {
    public static void main(String[] args) {
        Random r = new Random();
        Student[] stu = {new Student("张三", r.nextInt(100)),
                new Student("王五", r.nextInt(100)),
                new Student("赵六", r.nextInt(100)),
                new Student("李七", r.nextInt(100)),
                new Student("宋八", r.nextInt(100))
        };
        Arrays.sort(stu, new StudentComparator());

        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i]);
        }
    }

}