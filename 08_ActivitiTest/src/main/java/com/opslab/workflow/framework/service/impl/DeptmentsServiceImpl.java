package com.opslab.workflow.framework.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.opslab.workflow.framework.annotation.ServiceMethod;
import com.opslab.workflow.framework.dao.DeptmentsDao;
import com.opslab.workflow.framework.dao.SupportDao;
import com.opslab.workflow.framework.entity.business.Deptments;
import com.opslab.workflow.framework.entity.business.UserInfo;
import com.opslab.workflow.framework.exception.DataAccessException;
import com.opslab.workflow.framework.exception.ServicesException;
import com.opslab.workflow.framework.service.DeptmentsService;
import com.opslab.workflow.framework.service.UserInfoService;
import com.opslab.workflow.util.sec;

/**
* 业务方法
*/
@Service("deptmentsService")
@SuppressWarnings("rawtypes")
public class DeptmentsServiceImpl extends SupportServiceImpl<Deptments,String> implements DeptmentsService{
    private static Logger logger = Logger.getLogger(DeptmentsServiceImpl.class);

    @Resource(name = "deptmentsDao")
    
    private DeptmentsDao db;
    public DeptmentsDao getDb() {
		return db;
	}
	public void setDb(DeptmentsDao db) {
		this.db = db;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	@Override
    public SupportDao getdb() {
        return db;
    }

    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;


    @Override
    @ServiceMethod("获取全部的部门列表")
    public List<Deptments> deptList() {
        String hql="from Deptments t where valid='1'";
        return db.query(hql);
    }
    @Override
    @ServiceMethod("根据部门ID获取部门信息")
    public Deptments getDeptByDeptId(String detpId){
        String hql="from Deptments t where t.deptId=?";
        return db.queryFirst(hql,detpId);
    }

    @Override
    public boolean addDept(String parentId, String deptName) {
        Deptments dept = new Deptments();
        dept.setId(sec.uuid());
        dept.setDeptId(sec.uuid());
        dept.setDetpName(deptName);
        dept.setParentId(parentId);
        dept.setValid("1");
        try{
            db.saveOrUpdate(dept);
            return true;
        }catch (DataAccessException e){
            logger.error("新增部门报错:"+e.getMessage());
        }
        return false;
    }

    @Override
    public Deptments get(String s) throws ServicesException {
        String hql ="from Deptments t where t.deptId=?";
        return db.queryFirst(hql,s);
    }

    @Override
    public void deleteById(String s) throws ServicesException {
        Deptments deptments = get(s);
        deptments.setValid("0");
        db.saveOrUpdate(deptments);
    }

    @Override
    public List<UserInfo> getUsers(String detpId) {
        String hql ="from UserInfo t where t.deptId=? and valid='1'";
        return userInfoService.query(hql,detpId);
    }
}
