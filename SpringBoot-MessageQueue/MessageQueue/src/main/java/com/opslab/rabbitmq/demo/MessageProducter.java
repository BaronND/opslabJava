package com.opslab.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息生产者
 */
public class MessageProducter {
    public final static String QUEUE_NAME="rabbitMQ.test";


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 100; i++) {
            String message = "Hello World -"+i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Sent :" + message);
        }


        channel.close();
        connection.close();
    }
}
