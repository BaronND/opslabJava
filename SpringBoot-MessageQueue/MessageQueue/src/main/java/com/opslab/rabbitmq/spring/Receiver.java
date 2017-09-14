package com.opslab.rabbitmq.spring;

import com.opslab.App;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class Receiver {

    /**
     * 接受并处理消息
     * @param hello
     */
    @RabbitListener(queues = App.RABBITMQ_QUEUE_NAME)
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }
}