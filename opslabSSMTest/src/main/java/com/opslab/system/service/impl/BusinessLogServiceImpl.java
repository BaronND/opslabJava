package com.opslab.system.service.impl;

import com.opslab.system.model.BusinessLog;
import com.opslab.system.service.BusinessLogService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 实现业务日志service类
 */
@Service("businessLogService")
public class BusinessLogServiceImpl   implements BusinessLogService {
    @Resource(name = "sqlSession")
    protected SqlSession session;

    public void saveLog(BusinessLog log) {
        session.update("com.opslab.system.model.BusinessLog.saveBusinessLog", log);
    }


    public List<BusinessLog> queryPage(Map<Object, Object> params) {
        return session.selectList("com.opslab.system.model.BusinessLog.page", params);
    }
}
