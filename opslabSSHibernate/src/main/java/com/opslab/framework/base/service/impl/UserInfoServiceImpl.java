package com.opslab.framework.base.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.framework.base.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* 业务方法
*/
@SuppressWarnings("rawtypes")
@Service("userInfoService")
public class UserInfoServiceImpl extends SupportServiceImpl<UserInfo,String> implements UserInfoService{

    private  static LinkedHashMap whereExpression =   Maps.newLinkedHashMap(
            ImmutableMap.<String, String> builder()
                    .put("usercode", "usercode = :usercode")
                    .put("username", "username = :username")
                    .put("valid","valid = :valid")
                    .build());

    private static List<String> orderBy = Lists.newArrayList(
            "createTime desc"
        );
    /**
     * 查询最新的一页数据
     * @return
     */
    @Override
    public List<UserInfo> list(Map<String,Object> params,int page,int size) {
        String hql ="from UserInfo";
        return db.queryPageNameParameter(hql,whereExpression,params,orderBy,page, size);
    }

    @Override
    public Long count(Map<String,Object> params){
        String hql ="select count(*) from UserInfo";
        return db.countNameParameter(hql,whereExpression,params);
    }
}
