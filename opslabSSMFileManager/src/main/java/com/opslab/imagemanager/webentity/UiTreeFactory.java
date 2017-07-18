package com.opslab.imagemanager.webentity;

import com.opslab.imagemanager.domain.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 将对象转换为UiTree
 */
public class UiTreeFactory {

    /**
     * 封装父子节点关系树
     * @param menuList
     * @return
     */
    public static List<Menu> formatTree(List<Menu> menuList){
        if(menuList == null || menuList.size() == 0){
            return new ArrayList<>();
        }

        //根据节点类型区分是父节点和叶子节点
        List<Menu> parentList = new ArrayList<>();
        List<Menu> childList = new ArrayList<>();
        for(Menu menu:menuList){
            String type = menu.getType();
            if("leaf".equals(type)){
                childList.add(menu);
            }else{
                parentList.add(menu);
            }
        }
        return toformatTree(parentList,childList);
    }

    /**
     * 父子节点包含JSON数据相关的工具类
     * @param pList
     * @param cList
     * @return
     */
    public static List<Menu> toformatTree(List<Menu> pList, List<Menu> cList){
        List<Menu> r = new ArrayList<>();
        List<Menu> t = new ArrayList<>();
        if(pList != null && pList.size() > 0){
            for(Menu p:pList){
                r.add(p);
                for(Menu pp:pList){
                    if(p.getId().equals(pp.getpId())){
                        p.addChildren(pp);
                        t.add(pp);
                    }
                }
                for(Menu c:cList){
                    if(p.getId().toString().equals(c.getpId())){
                        p.addChildren(c);

                    }
                }
            }
        }
        r.removeAll(t);
        return r;
    }
}
