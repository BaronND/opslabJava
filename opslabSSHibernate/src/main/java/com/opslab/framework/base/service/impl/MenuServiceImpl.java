package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.entity.Menu;
import com.opslab.framework.base.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 业务方法
*/
@Service("menuService")
public class MenuServiceImpl extends SupportServiceImpl<Menu,String> implements MenuService{


    @Override
    public List<Menu> list() {
        String hql = "from Menu t ";
        return db.query(hql);
    }

    @Override
    public void delete(String id) {
        String hql = "update Menu t set t.valid='0' where t.id=?";
        db.execute(hql,id);
    }

    @Override
    public void activate(String id) {
        String hql ="update Menu t set t.valid='1' where t.id=?";
        db.execute(hql,id);
    }
}
