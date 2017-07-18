package com.opslab.mybatis.model;

/**
 * 学生实体类
 */
public class Student {
    /*学生学号*/
    private String id;
    /*学生名称*/
    private String name;
    /*学生班级ID*/
    private int cId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cId=" + cId +
                '}';
    }
}
