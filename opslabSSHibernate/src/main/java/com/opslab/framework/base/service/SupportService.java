package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.util.XmlSQLUtil;
import com.opslab.framework.base.util.impl.CommonXmlSQLUtil;

import java.io.Serializable;
import java.util.Collection;

/**
 * 实体的业务层对应的操作方法
 * 注意：
 * 此处使用非表明该操作属于业务层
 */
@SuppressWarnings("rawtypes")
public interface SupportService<T, ID extends Serializable> {


    @ServiceMethod("保存业务实体")
    void save(T t);

    @ServiceMethod("更新业务实体")
    void update(T t);

    @ServiceMethod("更新业务实体")
    void saveOrUpdate(T t);

    @ServiceMethod("删除业务实体")
    void delete(T t);

    @ServiceMethod("删除业务实体")
    void deleteById(ID id);

    @ServiceMethod("删除业务实体")
    void deleteAll(Collection cons);

    @ServiceMethod("加载业务实体")
    T load(ID id);

    @ServiceMethod("加载业务实体")
    T get(ID id);

}
