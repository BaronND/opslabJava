package JavaSE.compare;

import java.util.Arrays;

class StudentCom implements Comparable<StudentCom> {
    private String name;
    private int age;

    public StudentCom(String name, int age) {
        this.name = name;
        this.setAge(age);
    }

    public String toString() {
        return name + "\t" + getAge() + "\t";
    }

    public int compareTo1(StudentCom stu) {
        if (this.getAge() > stu.getAge()) {
            return -1;
        } else if (this.getAge() < stu.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(StudentCom o) {
        return 0;
    }
}

public class compare {
    public static void main(String[] args) {
        StudentCom stu[] = {new StudentCom("禅师", 24),
                new StudentCom("方丈", 50),
                new StudentCom("和尚", 11),
                new StudentCom("尼姑", 24),
                new StudentCom("人", 100)
        };
        Arrays.sort(stu);
        for (int i = 0; i < stu.length; i++) {
            System.out.println(stu[i]);
        }
    }
}