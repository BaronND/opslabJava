package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.Role;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务方法
 */
@Service("roleService")
public class RoleServiceImpl extends SupportServiceImpl<Role, String> implements RoleService {


    @Override
    @ServiceMethod("统计用户数")
    public Long count(boolean isAll) {
        String hql = "select count(*) from Role t where t.valid='1'";
        if (isAll) {
            hql = "select count(*) from Role t";
            return db.count(hql);
        }
        return db.count(hql);
    }

    @Override
    @ServiceMethod("获取角色列表")
    public List<Role> list(boolean isAll) {
        String hql = "from Role t where t.valid=?";
        if (isAll) {
            hql = "from Role t where 1=1";
            return db.query(hql);
        }
        return db.query(hql, "1");
    }


    @Override
    @ServiceMethod("统计角色下的用户数量")
    public Long count(String roleId) {
        String sql = "select count(*) from ops_re_roleuser t where t.roleId=?";
        return dbSql.count(sql, roleId);
    }

    /**
     * 根据角色Id获取到用户列表
     *
     * @param roleId
     * @param page
     * @param size
     * @return
     */
    @Override
    @ServiceMethod("根据角色id获取用户列表")
    public List<Object> userSet(String roleId, int page, int size) {
        String sql = "select u.* from ops_re_userInfo u,ops_re_roleuser r " +
                "where r.userId=u.userId and r.roleId=?";
        return dbSql.queryPage(UserInfo.class, sql, page, size, roleId);
    }
}
