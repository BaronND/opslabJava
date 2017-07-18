package com.opslab.imagemanager.service.impl;

import com.opslab.imagemanager.domain.Menu;
import com.opslab.imagemanager.service.MenuManagerService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by neptune on 2017/4/8 0008.
 */
@Service
public class MenuManagerServiceImpl extends SuperServiceImpl implements MenuManagerService {
    private static String PACKAGE_NAME = "com.opslab.imagemanager.domain.Menu.";

    @Override
    public int save(Menu menu) {
        return 0;
    }

    @Override
    public void delete(String id) {

    }



    @Override
    public void activate(String id) {

    }

    @Override
    public int count(Map<Object, Object> params) {
        return 0;
    }

    @Override
    public List<Menu> page(Map<Object, Object> params, int page, int size) {
        RowBounds rows = new RowBounds(page, size);
        return session.selectList(PACKAGE_NAME+"select",params,rows);
    }

    @Override
    public List<Menu> select(Map<Object, Object> params) {
        return session.selectList(PACKAGE_NAME+"select",params);
    }


}
