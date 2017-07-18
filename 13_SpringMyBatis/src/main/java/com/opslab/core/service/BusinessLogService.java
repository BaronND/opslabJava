package com.opslab.core.service;

import com.opslab.core.annotion.ServiceMethod;
import com.opslab.core.model.BusinessLog;

import java.util.List;
import java.util.Map;

/**
 * 业务日志service
 */
public interface BusinessLogService {

    /**
     * 保存业务日志
     * @param log
     */
    @ServiceMethod(value="保存业务日志")
    public void saveLog(BusinessLog log);

    /**
     * 根据给定的条件查询业务日志
     * @param params
     * @return
     */
    @ServiceMethod(value="查询业务日志")
    List<BusinessLog> queryPage(Map<Object, Object> params);
}
