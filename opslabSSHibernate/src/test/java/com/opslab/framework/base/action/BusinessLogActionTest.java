package com.opslab.framework.base.action;

import org.junit.Test;


public class BusinessLogActionTest extends SuperActionTest{

    @Test
    public void testInfo(){
        String url = "/log/business/info/bfb04b3183e244279d115f80c42f8b0d";
        httpInfo(url);
    }
}