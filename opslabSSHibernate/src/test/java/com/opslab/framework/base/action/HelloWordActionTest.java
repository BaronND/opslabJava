package com.opslab.framework.base.action;

import org.junit.Test;


public class HelloWordActionTest extends SuperActionTest {


    @Test
    public void testHello() {
        String url = "/hello";
        httpGetPrint(url);
    }

    @Test
    public void testTest1() {
        httpGetPrint("/hello/test1");
    }

    @Test
    public void testParams() {
        httpGetPrint("/hello/params?id=111");
    }

    @Test
    public void testParams1() throws Exception {
        httpInfo("/hello");
        httpInfo("/hello/params?id=111");
    }
}
