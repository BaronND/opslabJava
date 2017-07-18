package com.opslab.mybatis.xmlMapper;

import com.opslab.mybatis.App;
import com.opslab.mybatis.model.UserInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DynamicUserInfo extends App {

    @Test
    public void testIf(){
        String mapper = "UserInfo_dynamicSQL.userNameLike";

        Map<String,String> param = new HashMap<>();

        List<UserInfo> list = session.selectList(mapper, param);
        list.stream().forEach(user ->{
            System.out.println(user);
        });

        param.put("name","测试");


        list = session.selectList(mapper, param);
        list.stream().forEach(user ->{
            System.out.println(user);
        });

        param = new HashMap<>();
        param.put("status","1");
        list = session.selectList(mapper, param);
        list.stream().forEach(user ->{
            System.out.println(user);
        });

        param = new HashMap<>();
        param.put("name","测试");
        param.put("status","1");
        list = session.selectList(mapper, param);
        list.stream().forEach(user ->{
            System.out.println(user);
        });
    }

    @Test
    public void testSet(){
        String mapper = "UserInfo_dynamicSQL.update";

        Map<String,String> param = new HashMap<>();
        param.put("id","test2");
        param.put("name","测试");
        param.put("nick","测试昵称");
        int update = session.update(mapper, param);
        System.out.println("update rows:"+update);
    }


    @Test
    public void testChoose(){
        String mapper = "UserInfo_choose.userNameLike";
        Map<String,String> param = new HashMap<>();
        param.put("name","测试");

        List<Object> objects = session.selectList(mapper, param);
        objects.stream().forEach(obj ->{
            System.out.println((UserInfo)obj);
        });

        param.put("status","1");

        objects = session.selectList(mapper, param);
        objects.stream().forEach(obj ->{
            System.out.println((UserInfo)obj);
        });

        objects = session.selectList(mapper, new HashMap<>());
        objects.stream().forEach(obj ->{
            System.out.println((UserInfo)obj);
        });
    }

    @Test
    public void testForeach(){
        String mapper = "UserInfo_foreach.userNameLike";
        List<String> list = new ArrayList<>();
        list.add("mybatis");
        list.add("test2");

        List<Object> objects = session.selectList(mapper, list);
        objects.stream().forEach(obj ->{
            System.out.println((UserInfo)obj);
        });
    }
}
