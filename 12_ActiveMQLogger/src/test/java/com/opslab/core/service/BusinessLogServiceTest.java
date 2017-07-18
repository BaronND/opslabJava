package com.opslab.core.service;

import com.google.common.collect.ImmutableMap;
import com.opslab.SpringTest;
import com.opslab.core.model.BusinessLog;
import com.opslab.core.util.JacksonUtil;
import com.opslab.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试
 */
public class BusinessLogServiceTest extends SpringTest{
    private BusinessLogService service;

    @Before
    public void before() {
        super.before();
        service = (BusinessLogService) Context.getBean("businessLogService");
    }

    @Test
    public void testSave(){
        String clientId = "admin1602130927-53985-1481456210242-0:1";
        Date createDate = new Date();
        String className = "com.opslab.ActiveMQTest";
        String level = "info";
        String msgContent = "info msg";
        BusinessLog businessLog = new BusinessLog(createDate, clientId, "", className, level, msgContent);
        service.saveLog(businessLog);
    }



    @Test
    public void testQueryPage(){
        Map<Object,Object> params =
                ImmutableMap.builder().put("id", "0000047add0b4adf9a51fe8eefcc77d0")
                        .put("uri","/J2EE/userlogin")
                        .build();

        List<BusinessLog> businessLogs = service.queryPage(params);

        businessLogs.stream().forEach(log->{
            System.out.println(log);
        });


        params =
                ImmutableMap.builder()
                        .put("uri","/J2EE/userlogin")
                        .build();

        businessLogs = service.queryPage(params);

        businessLogs.stream().forEach(log->{
            System.out.println(log);
        });
    }
}