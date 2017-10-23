package com.opslab.service;

import com.opslab.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 0opslab
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class IUserInfoServiceTest {
    @Autowired
    IUserInfoService service;

    @Test
    public void testCount(){
        System.out.println(service.count());
    }
}