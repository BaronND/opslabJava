package com.opslab.framework.base.action;


import org.junit.Test;

public class MenuActionTest extends SuperActionTest{

    @Test
    public void testList(){
        String url ="/admin/menu";
        httpInfo(url);
    }
}