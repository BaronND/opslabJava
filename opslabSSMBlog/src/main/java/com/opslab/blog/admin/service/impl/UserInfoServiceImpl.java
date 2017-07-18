package com.opslab.blog.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.opslab.blog.admin.domain.UserInfo;
import com.opslab.blog.admin.service.UserInfoService;
import com.opslab.blog.util.JacksonUtil;
import com.opslab.blog.util.PackageUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @descript 用户操作接口
 */
@Service
public class UserInfoServiceImpl extends SuperServiceImpl implements UserInfoService {
    private static Logger logger = LogManager.getLogger(UserInfoServiceImpl.class);

    private static String MAPPER_SELECT = PackageUtil.mapperPackage(UserInfo.class) + "select";

    private static String MAPPER_UPDATEVALID = PackageUtil.mapperPackage(UserInfo.class) + "updateValid";

    private static String MAPPER_INSERT = PackageUtil.mapperPackage(UserInfo.class)+"insert";

    private static String MAPPER_COUNT = PackageUtil.mapperPackage(UserInfo.class) + "count";

    @Override
    public int count() {
        return session.selectOne(MAPPER_COUNT);
    }

    @Override
    public List<UserInfo> list(Map<Object, Object> params) {
        logger.debug(MAPPER_SELECT+"=>"+ JacksonUtil.toJSON(params));
        return session.selectList(MAPPER_SELECT,params);
    }

    @Override
    public int count(Map<Object, Object> params) {
        logger.debug(MAPPER_COUNT+"=>"+ JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_COUNT,params);
    }
    @Override
    public List<UserInfo> page(Map<Object,Object> params,int page,int size){
        RowBounds rows = new RowBounds((page - 1) * size, size);
        logger.debug(MAPPER_SELECT+"=>"+ JacksonUtil.toJSON(params));
        return session.selectList(MAPPER_SELECT,params,rows);
    }

    @Override
    public int save(UserInfo userInfo) {
        if(userInfo(userInfo.getUserId()) != null){
            logger.error("UserInfo is exists,UserId:"+userInfo.getUserId());
            return 0;
        }
        if(userInfoByUserCode(userInfo.getUserCode()) != null){
            logger.error("UserInfo is exists,usercode:"+userInfo.getUserCode());
            return 0;
        }
        if(userInfoByUserName(userInfo.getName()) != null){
            logger.error("UserInfo is exists,UserName:"+userInfo.getName());
            return 0;
        }
        if(userInfoByEmail(userInfo.getEmail()) != null){
            logger.error("UserInfo is exists,email:"+userInfo.getEmail());
            return 0;
        }
        logger.info("add userinfo:"+JacksonUtil.toJSON(userInfo));
        return session.insert(MAPPER_INSERT,userInfo);
    }

    @Override
    public int updateStatus(int userId, String status) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("userId", userId)
                        .put("status",status)
                        .build();
        logger.info("update valid:"+JacksonUtil.toJSON(params));
        return session.update(MAPPER_UPDATEVALID,params);
    }

    @Override
    public UserInfo userInfo(int userId) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("userId", userId)
                        .build();
        logger.debug("load userinfo"+JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT,params);
    }

    @Override
    public UserInfo userInfoByUserCode(String userCode) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("userCode", userCode)
                        .build();
        logger.debug("load userinfo"+JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT,params);
    }

    @Override
    public UserInfo userInfoByUserName(String name) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("name", name)
                        .build();
        logger.debug("load userinfo"+JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT,params);
    }

    @Override
    public UserInfo userInfoByEmail(String email) {
        ImmutableMap<Object, Object> params =
                ImmutableMap.builder()
                        .put("email", email)
                        .build();
        logger.debug("load userinfo"+JacksonUtil.toJSON(params));
        return session.selectOne(MAPPER_SELECT,params);
    }
}
