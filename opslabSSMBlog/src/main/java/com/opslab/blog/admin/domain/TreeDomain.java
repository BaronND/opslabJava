package com.opslab.blog.admin.domain;

/**
 * @author 0opslab
 * @descript 定于用于父子关系的业务实体的父类
 */
public interface  TreeDomain {
    //返回当前节点的id
    int getId();
    //返回父节点的ID
    int getPId();
    //用于返回节点的类型
    String getType();
}
