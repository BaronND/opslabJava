package com.opslab.workflow;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过父类然子类继承Spring环境,测试依据Spring相关的方法直接extends SpringTest
 */
public class SpringTest {
    /**spring content*/
    public ClassPathXmlApplicationContext Context;

    @Before
    public void before() {
        Context = new ClassPathXmlApplicationContext(
                "spring/Spring-beans-for-JUnit.xml");
    }

    @After
    public void after() {
        Context.close();
    }
}
