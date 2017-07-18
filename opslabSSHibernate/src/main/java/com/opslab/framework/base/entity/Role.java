package com.opslab.framework.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户角色
 */
public class Role {

    //角色id
    @JsonProperty("id")
    private String roleId;

    //角色名称
    @JsonProperty("name")
    private String roleName;

    //父id
    @JsonProperty("pId")
    private String parentId;

    //创建时间
    private String createTime;

    //是否有效
    private String valid;

    //工作组描述
    private String descript;

    //工作组用户
    //此处不做hibernate关联映射(因为没必要)
    @JsonIgnore
    private Set<UserInfo> users = new HashSet<UserInfo>();

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Set<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(Set<UserInfo> users) {
        this.users = users;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", valid='" + valid + '\'' +
                ", descript='" + descript + '\'' +
                '}';
    }
}
