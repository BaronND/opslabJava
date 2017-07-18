package com.opslab.core.service;

import com.opslab.SpringTest;
import com.opslab.core.model.UserInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by neptune on 2016/12/4 0004.
 */
public class UserInfoServiceTest extends SpringTest {
    private UserInfoService service;

    @Override
    public void before() {
        super.before();
        service = (UserInfoService) Context.getBean("userInfoService");
    }

    @Test
    public void queryUserInfoById() throws Exception {
        UserInfo userInfo = service.queryUserInfoById("157BC3CB12100019A7DC15D8BD6EB794");

        System.out.println(userInfo);
    }

    @Test
    public void queryUserByDeptId(){
        List<UserInfo> userInfos = service.queryUserByDeptId("6b823ba59a5948dd944c0fc157d2e1e7");

        userInfos.stream().forEach(userInfo -> {
            System.out.println(userInfo);
        });


        List<UserInfo> list = service.selectList(
                "6b823ba59a5948dd944c0fc157d2e1e7", new RowBounds(1, 10));

        System.out.println("===================================");
        list.stream().forEach(userInfo -> {
            System.out.println(userInfo);
        });

    }

}