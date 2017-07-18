package com.opslab.framework.base.service.impl;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.Deptments;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.service.DeptmentsService;
import com.opslab.framework.base.service.UserInfoService;
import com.opslab.util.RandomUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务方法
 */
@Service("deptmentsService")
@SuppressWarnings("rawtypes")
public class DeptmentsServiceImpl extends SupportServiceImpl<Deptments, String> implements DeptmentsService {
    private static Logger logger = Logger.getLogger(DeptmentsServiceImpl.class);


    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;


    @Override
    @ServiceMethod("获取全部的部门列表")
    public List<Deptments> deptList() {
        String hql = "from Deptments t where valid='1'";
        return db.query(hql);
    }

    @Override
    @ServiceMethod("根据部门ID获取部门信息")
    public Deptments getDeptByDeptId(String detpId) {
        String hql = "from Deptments t where t.deptId=?";
        return (Deptments) db.queryFirst(hql, detpId);
    }

    @Override
    public boolean addDept(String parentId, String deptName) {
        Deptments dept = new Deptments();
        dept.setId(RandomUtil.uuid());
        dept.setDeptId(RandomUtil.uuid());
        dept.setDetpName(deptName);
        dept.setParentId(parentId);
        dept.setValid("1");
        db.saveOrUpdate(dept);
        return true;

    }

    @Override
    public Deptments get(String s) {
        String hql = "from Deptments t where t.deptId=?";
        return (Deptments) db.queryFirst(hql, s);
    }

    @Override
    public void deleteById(String s) {
        Deptments deptments = get(s);
        deptments.setValid("0");
        db.saveOrUpdate(deptments);
    }

    @Override
    public List<UserInfo> getUsers(String detpId,int page,int size) {
        String hql = "from UserInfo t where t.deptId=? and valid='1'";
        return db.queryPage(hql,page,size, detpId);
    }

    @Override
    public Long countUser(String deptId){
        String hql = "select count(*) from UserInfo t where t.deptId=?";
        return db.count(hql,deptId);
    }
}
