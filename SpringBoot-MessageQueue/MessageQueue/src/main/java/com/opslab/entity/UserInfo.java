package com.opslab.entity;

import java.io.Serializable;

/**
 * Created by 0opslab
 * 业务实体
 */
public class UserInfo implements Serializable{
    private long key;
    private String userId;
    private String userName;
    private String email;

    public UserInfo() {
    }

    public UserInfo(long key, String userId, String userName, String email) {
        this.key = key;
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "key=" + key +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
