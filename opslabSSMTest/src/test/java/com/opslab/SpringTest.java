package com.opslab;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于测试依赖项目的方法
 */
public class SpringTest {
    /**
     * spring content
     */
    public ClassPathXmlApplicationContext Context;

    @Before
    public void before() {
        Context = new ClassPathXmlApplicationContext("spring/Spring-beans-for-JUnit.xml");
    }

    @After
    public void after() {
        Context.close();
    }
}
