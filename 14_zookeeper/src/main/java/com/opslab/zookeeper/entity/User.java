package com.opslab.zookeeper.entity;

import java.io.Serializable;

/**
 * Created by monsoon on 27/09/2017.
 */
public class User implements Serializable{
    private int userid;
    private String usercode;
    private String userName;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {
    }

    public User(int userid, String usercode, String userName) {
        this.userid = userid;
        this.usercode = usercode;
        this.userName = userName;
    }
}
