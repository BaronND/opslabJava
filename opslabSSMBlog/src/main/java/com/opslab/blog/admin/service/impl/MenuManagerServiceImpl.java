package com.opslab.blog.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.APP;
import com.opslab.blog.admin.domain.Menu;
import com.opslab.blog.admin.service.MenuManagerService;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.PackageUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 */
@Service
public class MenuManagerServiceImpl extends SuperServiceImpl implements MenuManagerService {

    private static Logger logger = LogManager.getLogger(MenuManagerServiceImpl.class);

    private static String MAPPER_SELECT = PackageUtil.mapperPackage(Menu.class) + "select";

    private static String MAPPER_UPDATEVALID = PackageUtil.mapperPackage(Menu.class) + "updateValid";

    private static String MAPPER_INSERT = PackageUtil.mapperPackage(Menu.class)+"insert";

    @Override
    public int save(Menu menu) {
        logger.info(JacksonUtil.toJSON(menu));
        return session.insert(MAPPER_INSERT,menu);
    }

    @Override
    public int delete(String id) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", id)
                        .put("valid", APP.STATUS_INVALID)
                        .build();
        logger.info(MAPPER_UPDATEVALID + "=>" + JacksonUtil.toJSON(params));
        return session.update(MAPPER_UPDATEVALID, params);
    }


    @Override
    public int activate(String id) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("id", id)
                        .put("valid", APP.STATUS_VALID)
                        .build();
        logger.info(MAPPER_UPDATEVALID + "=>" + JacksonUtil.toJSON(params));
        return session.update(MAPPER_UPDATEVALID, params);
    }


    @Override
    public List<Menu> page(Map<Object, Object> params, int page, int size) {
        RowBounds rows = new RowBounds(page, size);
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params) + "=>" + JacksonUtil.toJSON(rows));
        return session.selectList(MAPPER_SELECT, params, rows);
    }

    @Override
    public List<Menu> select(Map<Object, Object> params) {
        logger.debug(MAPPER_SELECT + "=>" + JacksonUtil.toJSON(params));
        return session.selectList(MAPPER_SELECT, params);
    }


}
