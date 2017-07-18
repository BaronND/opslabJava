package com.opslab.mybatis.xmlMapper;

import com.opslab.mybatis.App;
import com.opslab.mybatis.model.UserInfo2;
import org.junit.Test;

import java.util.List;

/**
 * 明确的给业务实体和数据库表字段的对应关系
 */
public class UserInfo2Test extends App {
    @Test
    public void insert(){
        int insert =
                session.insert("com.opslab.mybatis.model.UserInfo2.save",
                        new UserInfo2("test2", "测试账号", "账号昵称", 20));
        System.out.println("insert rows:"+insert);
    }

    @Test
    public void selectAll(){
        List<UserInfo2> list =
                session.selectList("com.opslab.mybatis.model.UserInfo2.selectAll");
        list.stream().forEach(userInfo ->{
            System.out.println(userInfo);
        });
    }
}
