package com.opslab.blog.admin.service;

import com.opslab.blog.admin.domain.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
public interface MenuManagerService {

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    int save(Menu menu);


    /**
     * 停用或删除菜单
     */
    int delete(String id);


    /**
     * 启用菜单
     */
    int activate(String id);



    /**
     * 查询上传记录
     * @param params
     * @param page
     * @param size
     * @return
     */
    List<Menu> page(Map<Object,Object> params, int page, int size);

    /**
     * 查询上传记录
     * @param params
     * @return
     */
    List<Menu> select(Map<Object,Object> params);
}
