package com.opslab.mybatis.xmlMapper;

import com.opslab.mybatis.App;
import com.opslab.mybatis.model.UserInfo;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 演示见得的使用mybatis
 */
public class UserInfoTest extends App {

    @Test
    public void insert(){
        int insert =
                session.insert("UserInfo.save",
                        new UserInfo("test", "测试账号", "账号昵称", 20));
        System.out.println("insert rows:"+insert);
    }

    @Test
    public  void getUser() throws FileNotFoundException {
        UserInfo user =
                session.selectOne("UserInfo.getUser", "test");
        System.out.println(user);
    }

    @Test
    public void getUserWithUserName(){
        List<UserInfo> userList =
                session.selectList("UserInfo.userNmae", "测试账号");

        userList.stream().forEach(UserInfo ->{
            System.out.println(UserInfo);
        });
    }


    @Test
    public void changeNick(){
        UserInfo user =
                session.selectOne("UserInfo.getUser", "test");
        user.setNick("修改后的昵称");
        int update = session.update("UserInfo.changeNick", user);
        System.out.println("update rows:"+update);


        //以单独的方式传递一个map从而可能避免从数据库中查询的并获得一个javabean的问题
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("id","test");
        params.put("nick","Map修改后的昵称");
        session.update("UserInfo.changeNick",params);
    }

    @Test
    public void deleteById(){
        int i = session.delete("UserInfo.deleteById", "test");
        System.out.println("delete rows:"+i);
    }


    @Test
    public void testResultMapConstructor(){
        List<UserInfo> users = session.selectList("UserInfo_constructor.constructor", "test");
        users.stream().forEach(userInfo -> {
            System.out.println(userInfo);
        });
    }
}
