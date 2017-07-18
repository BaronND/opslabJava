package com.opslab.mybatis.model;

import java.util.List;

/**
 * 年纪信息
 */
public class ClassInfo {
    /*班级id*/
    private int id;
    /*班级名称*/
    private String name;
    /*班主任*/
    private Loader loader;
    /*学生信息*/
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Loader getLoader() {
        return loader;
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loader=" + loader +
                ", students=" + students +
                '}';
    }
}
