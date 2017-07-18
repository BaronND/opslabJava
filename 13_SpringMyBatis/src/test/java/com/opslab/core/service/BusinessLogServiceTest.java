package com.opslab.core.service;

import com.google.common.collect.ImmutableMap;
import com.opslab.SpringTest;
import com.opslab.core.model.BusinessLog;
import com.opslab.util.RandomUtil;
import org.junit.Before;
import org.junit.Test;

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
    public void testSaveLog(){
        BusinessLog log = new BusinessLog();
        log.setId(RandomUtil.uuid());
        log.setBusinessName("测试业务类");
        service.saveLog(log);
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