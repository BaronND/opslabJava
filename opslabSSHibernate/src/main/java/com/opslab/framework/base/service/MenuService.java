package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.Menu;

import java.util.List;

/**
* 业务方法接口
*/
public interface MenuService extends SupportService<Menu,String> {

    @ServiceMethod("获取所有菜单")
    List<Menu> list();


    @ServiceMethod("停用或删除菜单")
    void delete(String id);


    @ServiceMethod("启用菜单")
    void activate(String id);
}

