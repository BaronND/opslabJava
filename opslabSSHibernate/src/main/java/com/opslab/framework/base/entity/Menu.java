package com.opslab.framework.base.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 系统菜单实体
 */
public class Menu {
    /*编码id*/
    private  String id;

    /*上级菜单*/
    private  String pId;

    /*url地址*/
    private String address;

    /*地址名称*/
    private String name;

    /*菜单类型*/
    private String type;

    /*是否有效*/
    private String valid;

    /*描述*/
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
