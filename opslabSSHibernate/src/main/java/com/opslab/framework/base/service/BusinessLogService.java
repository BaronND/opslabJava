package com.opslab.framework.base.service;

import com.opslab.framework.base.annotation.ServiceMethod;
import com.opslab.framework.base.entity.BusinessLog;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 */
public interface BusinessLogService extends SupportService<BusinessLog,String> {


    @ServiceMethod("获取日志记录数")
    Long count(Map<String,Object> params);

    @ServiceMethod("查询业务日志")
    List<BusinessLog> list(Map<String,Object> params,int page, int size);
}
