package com.opslab.framework.base.service;

import com.opslab.util.Password;
import com.opslab.util.RandomUtil;
import com.opslab.framework.base.entity.UserInfo;
import com.opslab.util.JacksonUtil;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

/**
 * 此处使用UserInfoService对SupportDao进行全面完整的测试
 * 之所以才service层做完整的测试，使用系统在service做了事物的aop
 * 同时在service也就是业务层做测试更符合实际情况
 */
@ContextConfiguration("classpath:spring/Spring-beans-for-JUnit.xml")
public class UserInfoServiceTest extends AbstractJUnit4SpringContextTests {
    @Resource(name="userInfoService")
    private UserInfoService service;

    @Test
    public void testAddUser(){
        String[] depts = {"7a7aec6f81924ad890ee2a0e5ccf42f7",
                "7a7aec6f81924ad890ee2a0e5ccf42f7",
                "6b823ba59a5948dd944c0fc157d2e1e7",
                "794a2d0fc8ba47bfa7cc30d2886c7389",
                "ced7cd1f058c4e30917b8d99a7493793",
                };

        for(int i=200001;i<201000;i++) {
            int index = RandomUtil.integer(0,depts.length);
            UserInfo userInfo = new UserInfo(String.valueOf(i),String.valueOf(i), depts[index], Password.md5("1"));
            service.save(userInfo);
        }
    }



    @Test
    public void testQueryPage() throws Exception {
        List<UserInfo> userList= service.list(null,1,10);
        System.out.println(JacksonUtil.toJSON(userList));
    }










/*

    @Test
    public void testQuerySQLEntityL() throws Exception {
        String sql = "select * from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        List<Object> userList = service.querySQLEntity(UserInfo.class, sql);
        System.out.println(JacksonUtil.toJSON(userList));
    }

    @Test
    public void testQuerySQLEntityPage() throws Exception {
        String sql = "select * from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        List<Object> userList = service.querySQLEntityPage(UserInfo.class, sql,1,2);
        System.out.println(JacksonUtil.toJSON(userList));
    }

    @Test
    public void testQueryFirstSQLEntity() throws Exception {
        String sql = "select * from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        UserInfo userInfo = (UserInfo) service.queryFirstSQLEntity(UserInfo.class, sql);
        System.out.println(JacksonUtil.toJSON(userInfo));
    }

    @Test
    public void testQueryLastSQLEntity() throws Exception {
        String sql = "select * from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        UserInfo userInfo = (UserInfo) service.queryLastSQLEntity(UserInfo.class, sql);
        System.out.println(JacksonUtil.toJSON(userInfo));
    }

    @Test
    public void testQueryArray() throws Exception {
        String sql = "select u.userId,u.userName from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        List<Object[]> objects = service.queryArray(sql);
        if(objects!= null){
            for(Object[] object:objects){
                System.out.println(Arrays.toString(object));
            }
        }
    }

    @Test
    public void testQueryArrayPage() throws Exception {
        String sql = "select u.userId,u.userName from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        List<Object[]> objects = service.queryArrayPage(sql,1,2);
        if(objects!= null){
            for(Object[] object:objects){
                System.out.println(Arrays.toString(object));
            }
        }
    }

    @Test
    public void testQueryFirstArray() throws Exception {
        String sql = "select u.userId,u.userName from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        Object[] objects = service.queryFirstArray(sql);
        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void testQueryLastArray() throws Exception {
        String sql = "select u.userId,u.userName from ops_re_userInfo u " +
                "where exists (select * from ops_re_roleuser r where r.userId = u.userId)";
        Object[] objects = service.queryLastArray(sql);
        System.out.println(Arrays.toString(objects));
    }
    */
}