package com.opslab.framework.base.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.opslab.framework.base.entity.BusinessLog;
import com.opslab.framework.base.service.BusinessLogService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 */
@Service("businessLogService")
public class BusinessLogServiceImpl extends SupportServiceImpl<BusinessLog,String> implements BusinessLogService{

    //定义统一的SQL条件,查询时会自动根据参数列表过滤，然后执行命名的参数化查询
    private  static LinkedHashMap whereExpression =   Maps.newLinkedHashMap(
            ImmutableMap.<String, String> builder()
                    .put("startTime", "startTime >= :startTime")
                    .put("endTime", "startTime <= :endTime")
                    .put("userName","userName = :userName")
                    .put("businessName", "businessName like '%:businessName%'")
                    .put("result","result = :result")
                    .build());

    private static List<String> orderBy = Lists.newArrayList(
            "startTime desc",
            "result asc"
            );
    public List<BusinessLog> list(Map<String,Object> params,int page, int size){
        return db.queryPageNameParameterXml(
                "BUSINESSLOG_COUNT_HQL",whereExpression,params,orderBy,page,size);
    }

    @Override
    public Long count(Map<String,Object> params) {
        String hql = "select count(*) from BusinessLog";
        return db.countNameParameter(hql,whereExpression,params);
    }
}
