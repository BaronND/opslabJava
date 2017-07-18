package com.opslab.mybatis.mapper;

import com.opslab.mybatis.App;
import com.opslab.mybatis.model.UserInfo;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 使用注解的方式生成dao的操作方法
 */
public class IUserInfoMapperTest extends App {
    private IUserInfoMapper mapper;


    @Override
    public void before() throws FileNotFoundException {
        super.before();
        mapper = session.getMapper(IUserInfoMapper.class);
    }

    @Test
    public void getUserInfoById() throws Exception {
        UserInfo test = mapper.getUserInfoById("test");
        System.out.println(test);
    }


    @Test
    public void userInfo() {
        List<UserInfo> list = mapper.userInfoAll();
        list.stream().forEach(UserInfo -> {
            System.out.println(UserInfo);
        });
    }

    @Test
    public void changeNick(){
        UserInfo userInfo = new UserInfo();
        userInfo.setNick("数据库操作利器");
        userInfo.setId("mybatis");

        int nick = mapper.changeNick(userInfo);
        System.out.println(nick);
    }
}