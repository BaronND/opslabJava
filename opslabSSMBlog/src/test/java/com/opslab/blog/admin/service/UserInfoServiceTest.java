package com.opslab.blog.admin.service;

import com.opslab.blog.admin.APP;
import com.opslab.blog.admin.SuperServiceTest;
import com.opslab.blog.admin.domain.UserInfo;
import com.opslab.blog.util.PassWordUtil;
import com.opslab.blog.util.RandomUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 0opslab
 * @descript 请添加说明
 */
public class UserInfoServiceTest extends SuperServiceTest{
    @Autowired
    private UserInfoService service;

    @Test
    public void count() throws Exception {
        print(service.count());
    }

    @Test
    public void list() throws Exception {
        List<UserInfo> list =  service.list(null);
        print(list);
    }

    @Test
    public void save() throws Exception {
        for (int i = 0; i < 100; i++) {
            String userCode = RandomUtil.String(10);
            UserInfo userInfo = new UserInfo(userCode, userCode, userCode+"@qq.com",
                    PassWordUtil.md5("12345"), APP.STATUS_VALID, 100001);
            print(service.save(userInfo));
        }
    }

    @Test
    public void updateStatus() throws Exception {

    }

    @Test
    public void userInfo() throws Exception {

    }

}