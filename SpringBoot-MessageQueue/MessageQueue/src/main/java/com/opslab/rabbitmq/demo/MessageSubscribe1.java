package com.opslab.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by 0opslab
 * message subscribel 消息订阅者1
 */
public class MessageSubscribe1 {
    public static final String RABBITMQ_QUEUE_NAME = "MESSAGE-PUBLISH";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        //声明消息路由的名称和类型
        channel.exchangeDeclare(RABBITMQ_QUEUE_NAME, "fanout");

        //声明一个随机消息队列
        String queueName = channel.queueDeclare().getQueue();

        //绑定消息队列和消息路由
        channel.queueBind(queueName, RABBITMQ_QUEUE_NAME, "");

        System.out.println(" 消息订阅者启动成功");

        QueueingConsumer consumer = new QueueingConsumer(channel);

        //启动一个消费者
        channel.basicConsume(queueName, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());

            System.out.println(" [x] Received '" + message + "'");
        }
    }
}
