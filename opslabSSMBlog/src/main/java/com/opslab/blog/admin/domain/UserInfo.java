package com.opslab.blog.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author 0opslab
 * @descript 用户信息
 */
public class UserInfo {
    //用户id
    private int userId;

    //用户编码
    private String userCode;

    //用户昵称
    private String name;

    //用户邮箱
    private String email;

    //用户密码
    @JsonIgnore
    private String password;

    private Date createTime;

    //用户状态
    private String status;

    //用户部门
    private int deptId;

    public UserInfo() {
    }

    public UserInfo(String userCode, String name, String email, String password, String status, int deptId) {
        this.userCode = userCode;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.createTime = new Date();
        this.deptId = deptId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userCode='" + userCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
