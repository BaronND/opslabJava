package com.opslab.serviceimpl;

import com.opslab.domain.UserInfo;
import com.opslab.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by 0opslab
 */
@Service
public class UserInfoServiceImpl extends SuperService implements IUserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    private static String MAPPER_SELECT = mapperPackage(UserInfo.class , "select");

    private static String MAPPER_UPDATEVALID = mapperPackage(UserInfo.class,"updateValid") ;

    private static String MAPPER_INSERT = mapperPackage(UserInfo.class,"insert") ;

    private static String MAPPER_COUNT = mapperPackage(UserInfo.class,"count");

    @Override
    public int count() {
       // return session.selectOne(MAPPER_COUNT);
        return 0;
    }
}
