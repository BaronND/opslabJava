package com.opslab.framework.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 工作组
 */
public class WorkGroup {

    //工作组id
    @JsonProperty("id")
    private String groupId;

    //共组做名称
    @JsonProperty("name")
    private String groupName;

    //父id
    @JsonProperty("pId")
    private String parentId;

    //创建时间
    private String createTime;

    //是否有效
    private String valid;

    //工作组描述
    @JsonIgnore
    private String descript;

    //工作组用户
    @JsonIgnore
    private List<UserInfo> users;

    public String getGroupId() {
        return groupId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "WorkGroup{" +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", valid='" + valid + '\'' +
                ", descript='" + descript + '\'' +
                '}';
    }
}
