package com.opslab.springboot.service;

import com.opslab.springboot.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by monsoon on 28/05/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class HelloServiceTest {
    @Autowired
    HelloService service;

    @org.junit.Test
    public void say() throws Exception {
        assertEquals("Hello Say",service.say());
    }

}