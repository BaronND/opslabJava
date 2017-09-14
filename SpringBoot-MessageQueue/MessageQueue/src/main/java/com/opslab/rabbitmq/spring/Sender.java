package com.opslab.rabbitmq.spring;

import com.opslab.App;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 消息生产者，将消息发送到rabbitmq
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param queueName
     * @param message
     */
    public void send(String queueName,String message) {
        this.rabbitTemplate.convertAndSend(queueName, message);
    }
}
