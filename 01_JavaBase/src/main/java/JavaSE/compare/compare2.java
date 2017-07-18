package JavaSE.compare;

class PersonCom {
    private String name;
    private int age;

    public PersonCom(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Person)) {
            if (this == obj) {
                return true;
            } else {
                PersonCom stu = (PersonCom) obj;
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

    public int hashCode() {
        return this.name.hashCode() * this.age;        //鎸囧畾缂栫爜鍏纺
    }

    //鎸囧畾鎺掑簭瑙勫垯
    public int compareTo(Student stu) {
        if (this.age > stu.getAge()) {
            return -1;
        } else if (this.age < stu.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }
}