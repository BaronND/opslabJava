package com.opslab.mybatis.model;


public class UserInfo2 {
    private String userId;

    private String userName;

    private String userNick;

    private int userAge;

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

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public UserInfo2() {
    }

    public UserInfo2(String userId, String userName, String userNick, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userNick = userNick;
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "UserInfo2{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userNick='" + userNick + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
