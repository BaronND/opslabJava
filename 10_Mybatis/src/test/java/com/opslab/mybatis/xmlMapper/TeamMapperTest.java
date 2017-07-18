package com.opslab.mybatis.xmlMapper;

import com.opslab.mybatis.model.Team;
import org.junit.Test;
import com.opslab.mybatis.App;

/**
 * 测试一对一映射
 */
public class TeamMapperTest extends App{
    private String Mapper = "com.opslab.mybatis.model.Team";
    @Test
    public void testMethod1(){
        Team team = session.selectOne(Mapper + ".getTeam", 1);
        System.out.println(team);

        team = session.selectOne(Mapper+".method2",1);
        System.out.println(team);
    }
}
