package com.opslab.framework.base.service;

import com.opslab.framework.SpringTest;
import com.opslab.util.Password;
import org.junit.Before;
import org.junit.Test;


public class LoginServiceTest extends SpringTest{
    private LoginService service;

    @Before
    public void before(){
        super.before();
        service = (LoginService) Context.getBean("loginService");
    }

    @Test
    public void testLogin(){
        System.out.println(new Boolean(true));
        boolean result = service.login("10001", Password.md5("1"));
        System.out.println(result);
    }

}