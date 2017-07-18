package com.opslab.framework.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.dao.DBDao;
import com.opslab.framework.base.dao.DBUtil;
import com.opslab.framework.base.dao.SuperQueryDao;
import com.opslab.framework.base.dao.SupportDao;
import com.opslab.framework.base.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author 0opslab
 *         通用的业务层方法实现
 */
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class SupportServiceImpl<T, ID extends Serializable> implements SupportService<T, ID> {

    @Autowired
    protected SupportDao<T,ID> db;

    @Resource(name="dbSql")
    protected DBDao dbSql;

    @Resource(name="dbUtils")
    protected DBUtil dbUtil;


	@Override
    @ServiceMethod("保存实体方法")
    public void save(T t) {
        db.save(t);
    }

    @Override
    @ServiceMethod("更新实体方法")
    public void update(T t) {
        db.update(t);
    }

    @Override
    @ServiceMethod("更新活保存实体方法")
    public void saveOrUpdate(T t) {
        db.saveOrUpdate(t);
    }

    @Override
    @ServiceMethod("删除实体方法")
    public void delete(T t) {
        db.delete(t);
    }

    @Override
    @ServiceMethod("删除实体方法")
    public void deleteById(ID id) {
        db.deleteById(id);
    }

	@Override
    @ServiceMethod("删除一组实体")
    public void deleteAll(Collection cons) {
        db.deleteAll(cons);
    }

    @Override
    @ServiceMethod("加载实体方法")
    public T load(ID id) {
        return  db.load(id);
    }

    @Override
    @ServiceMethod("加载实体方法")
    public T get(ID id) {
        return db.get(id);
    }



}
