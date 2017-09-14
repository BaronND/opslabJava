package com.opslab.rabbitmq.spring;

import com.opslab.App;
import com.opslab.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试消息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class SenderTest {

    @Autowired
    public Sender sender;

    @Test
    public void send() throws Exception {
        sender.send(App.RABBITMQ_QUEUE_NAME, "message");
    }

}