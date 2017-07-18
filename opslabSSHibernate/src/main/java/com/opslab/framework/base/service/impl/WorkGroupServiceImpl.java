package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.entity.WorkGroup;
import com.opslab.framework.base.service.WorkGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务方法
 */
@Service("workGroupService")
public class WorkGroupServiceImpl extends SupportServiceImpl<WorkGroup, String> implements WorkGroupService {


    @Override
    public Long count(boolean isAll) {
        String hql = "select count(*) from WorkGroup t where t.valid=?";
        if (isAll) {
            hql = "select count(*) from WorkGroup t where 1=1";
            return db.count(hql);
        }
        return db.count(hql, "1");
    }

    @Override
    public List<WorkGroup> list(boolean isAll) {
        String hql = "from WorkGroup t where t.valid=?";
        if (isAll) {
            hql = "from WorkGroup t where 1=1";
            return db.query(hql);
        }
        return db.query(hql, "1");

    }

    @Override
    public Long countUser(String groupId) {
        return dbUtil.countXml("WORKGROUP_USER_COUNT_SQL",groupId);
    }
}
