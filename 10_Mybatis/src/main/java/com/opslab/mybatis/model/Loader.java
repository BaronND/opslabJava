package com.opslab.mybatis.model;

/**
 * 团队领袖
 */
public class Loader {

    private String id;
    private String name;

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

    @Override
    public String toString() {
        return "Loader{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
