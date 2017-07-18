package com.opslab.system.action;

import com.opslab.SpringActionTest;
import org.junit.Test;

/**
 * 测试用户来
 */
public class UserInfoActionTest extends SpringActionTest {


    @Test
    public void testUserInfo() {
        String url = "/user/info/157BC3CB0630001685EC422C904F784E";
        httpInfo(url);
    }
}