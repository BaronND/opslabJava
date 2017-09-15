package com.opslab.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 0opslab
 * message publish  消息发布、定于模式
 */
public class MessagePublish {
    public static final String RABBITMQ_QUEUE_NAME = "MESSAGE-PUBLISH";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel =  connection.createChannel();

        //声明exchange名字以及类型
        channel.exchangeDeclare(RABBITMQ_QUEUE_NAME, "fanout");

        for (int i = 0; i < 100; i++) {
            // getMessage的实现请见上篇博文
            String message = "message"+i;
            //指定exchange的名字
            channel.basicPublish(RABBITMQ_QUEUE_NAME, "", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }


        channel.close();
        connection.close();
    }
}
