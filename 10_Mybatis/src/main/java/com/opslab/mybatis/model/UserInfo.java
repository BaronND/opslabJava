package com.opslab.mybatis.model;


public class UserInfo {
    private String id;

    private String name;

    private String nick;

    private int age;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", age=" + age +
                '}';
    }

    public UserInfo() {
    }

    public UserInfo(String id, String name, String nick, Integer age) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.age = age;
    }
}
