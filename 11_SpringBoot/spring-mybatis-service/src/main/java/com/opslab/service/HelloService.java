package com.opslab.service;

import com.google.common.collect.ImmutableMap;
import com.opslab.domain.UserInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@EnableAutoConfiguration
@Service("helloService")
public class HelloService {

    @Autowired
    private SqlSession session;

    @Value("configValue")
    private String configValue;

    public String sayHello(){
        return "hello Spring boot:"+configValue;
    }

    public List<UserInfo> userInfo(){
        Map<Object,Object> params = ImmutableMap.builder()
//                .put("userId", userId)
                .build();
        RowBounds rows = new RowBounds(0, 100);


        List<UserInfo> list = session.selectList("com.opslab.domain.UserInfo.page",params,rows);
        if(list != null && list.size() > 0){
            return list;
        }
        return new ArrayList<UserInfo>();
    }
}
