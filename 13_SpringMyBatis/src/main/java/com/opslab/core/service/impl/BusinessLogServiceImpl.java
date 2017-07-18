package com.opslab.core.service.impl;

import com.opslab.core.annotion.ServiceMethod;
import com.opslab.core.model.BusinessLog;
import com.opslab.core.service.BusinessLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 实现业务日志service类
 */
@Service("businessLogService")
public class BusinessLogServiceImpl extends SuperService implements BusinessLogService{


    public void saveLog(BusinessLog log) {
        session.update("com.opslab.core.model.BusinessLog.saveBusinessLog",log);
    }


    public List<BusinessLog> queryPage(Map<Object, Object> params) {
        return session.selectList("com.opslab.core.model.BusinessLog.page",params);
    }
}
