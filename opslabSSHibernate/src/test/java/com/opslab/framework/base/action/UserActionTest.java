package com.opslab.framework.base.action;


import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

public class UserActionTest extends SuperActionTest{

    @Test
    public void testUser(){
        String url = "/admin/user";
        httpInfo(url);

    }

    @Test
    public void testList(){
        String url = "admin/user/list";
        Map<String, String> params = ImmutableMap.<String, String> builder()
                .put("page", "1")
                .put("rows", "20")
                .build();

        httpInfo(url,params);
    }
}

