package com.opslab.system.model;

/**
 * 业务实体
 */
public class UserInfo {
    private String id;

    private String userCode;

    private String userName;

    private String deptId;

    private String password;

    private String valid;

    private String createTime;

    public UserInfo() {
        super();
    }

    public UserInfo(String userCode, String userName, String deptId, String password) {
        this.userCode = userCode;
        this.userName = userName;
        this.deptId = deptId;
        this.password = password;
        this.valid = "1";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
