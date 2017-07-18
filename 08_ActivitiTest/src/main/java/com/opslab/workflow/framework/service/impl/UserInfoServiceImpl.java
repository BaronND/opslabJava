package com.opslab.workflow.framework.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opslab.workflow.APP;
import com.opslab.workflow.framework.dao.SupportDao;
import com.opslab.workflow.framework.dao.UserInfoDao;
import com.opslab.workflow.framework.entity.Page;
import com.opslab.workflow.framework.entity.business.UserInfo;
import com.opslab.workflow.framework.service.UserInfoService;

/**
* 业务方法
*/
@SuppressWarnings("rawtypes")
@Service("userInfoService")
public class UserInfoServiceImpl extends SupportServiceImpl<UserInfo,String> implements UserInfoService{

    @Resource(name = "userInfoDao")
    
    private UserInfoDao db;
    public UserInfoDao getDb() {
		return db;
	}


	public void setDb(UserInfoDao db) {
		this.db = db;
	}

	@Override
    public SupportDao getdb() {
        return db;
    }


    /**
     * 查询最新的一页数据
     * @return
     */
    @Override
    public List<Object> list() {
        String hql ="from UserInfo t where 1=1 order by t.createTime desc";
        Page page = page(hql, 1, APP.PAGE_SIZE);
        return page.getList();
    }
}
