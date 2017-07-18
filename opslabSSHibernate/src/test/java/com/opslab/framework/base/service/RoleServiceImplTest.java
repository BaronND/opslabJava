package com.opslab.framework.base.service;

import com.opslab.util.JacksonUtil;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration("classpath:spring/Spring-beans-for-JUnit.xml")
public class RoleServiceImplTest extends AbstractJUnit4SpringContextTests {
    @Resource(name="roleService")
    private RoleService service;



    @Test
    public void testList() throws Exception {

    }

    @Test
    public void testGetUserList() throws Exception {
        List<Object> userSet = service.userSet("15cc21fe515911e68b70524f970a68ec", 1, 20);
        System.out.println(JacksonUtil.toJSON(userSet));


        userSet = service.userSet("15cc21fe515911e68b70524f970a68ea", 1, 20);
        System.out.println(JacksonUtil.toJSON(userSet));
    }

    @Test
    public void testCount(){
        Long count = service.count("15cc21fe515911e68b70524f970a68ec");
        System.out.println("该角色下共计用户数量:"+count);
    }
}