package com.opslab.mybatis.xmlMapper;

import com.opslab.mybatis.App;
import com.opslab.mybatis.model.ClassInfo;
import org.junit.Test;

/**
 * 一对多的测试
 */
public class ClassInfoMapperTest extends App {
    @Test
    public void testOne2Many(){
        ClassInfo classInfo =session.selectOne("com.opslab.mybatis.model.ClassInfo.method1",1);
        System.out.println(classInfo);

        classInfo =session.selectOne("com.opslab.mybatis.model.ClassInfo.method2",1);
        System.out.println(classInfo);
    }
}
