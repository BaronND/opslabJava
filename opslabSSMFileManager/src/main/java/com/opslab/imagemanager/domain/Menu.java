package com.opslab.imagemanager.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 系统菜单实体
 */
public class Menu {
    /*编码id*/
    private String id;

    /*上级菜单*/
    private String pId;

    /*地址名称*/
    private String name;

    /*创建时间*/
    private Date time;

    /*菜单类型*/
    private String type;

    /*是否有效*/
    private String valid;

    /*url地址*/
    private String address;


    private List<Menu> children = new ArrayList<Menu>();



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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void addChildren(Menu menu){
        children.add(menu);
    }
    public void addChildren(List<Menu> menus){
        children.addAll(menus);
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
