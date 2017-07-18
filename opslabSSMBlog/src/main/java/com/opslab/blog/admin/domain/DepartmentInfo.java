package com.opslab.blog.admin.domain;

import java.util.Date;

/**
 * @author 0opslab
 * @descript 部门信息
 */
public class DepartmentInfo {
    public int deptId;

    public String name;

    private int parentId;

    private String treeType;

    private String status;

    private Date createTime;

    private String memo;

    public DepartmentInfo() {
    }

    public DepartmentInfo(String name, int parentId, String treeType, String status, String memo) {
        this.name = name;
        this.parentId = parentId;
        this.treeType = treeType;
        this.status = status;
        this.createTime = new Date();
        this.memo = memo;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", treeType='" + treeType + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", memo='" + memo + '\'' +
                '}';
    }
}
