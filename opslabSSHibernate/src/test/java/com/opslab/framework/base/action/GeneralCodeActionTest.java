package com.opslab.framework.base.action;


import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

public class GeneralCodeActionTest extends SuperActionTest{

    @Test
    public void testUser(){
        String url ="admin/code/save";

        Map<String,String> params = ImmutableMap.<String, String>builder()
                .put("codeId","USER_TYPE_05")
                .put("codeType","USER_TYPE")
                .put("codeName","高级VIP用户")
                .put("orderId","5")
                .put("desc","开通VIP的用户")
                .build();

        httpInfo(url,params);
    }


    @Test
    public void testCodeList(){
        String url="/admin/code/codelist";
        httpInfo(url);
    }

}

