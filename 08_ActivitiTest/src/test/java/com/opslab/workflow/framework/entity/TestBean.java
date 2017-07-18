package com.opslab.workflow.framework.entity;


import java.util.Date;

/**
 * @author 0opslab
 * 主要用于测试db工具类
 * 对应test表创建实体对象
 */
public class TestBean {
    private Integer id;
    private String name;
    private String address;
    private Date year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", year=" + year +
                '}';
    }
}
