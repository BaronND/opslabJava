package com.opslab.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by 0opslab
 * 消息消费者
 */
public class _4Consumer {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");

        JedisPubSub redisPubSub = new JedisPubSub() {

            /**
             * 取消订阅时候的处理
             * @param channel
             * @param subscribedChannels
             */
            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
            }

            /**
             * 初始化订阅时候的处理
             * @param channel
             * @param subscribedChannels
             */
            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
            }

            /**
             * 取消按表达式的方法订阅的时候处理
             * @param pattern
             * @param subscribedChannels
             */
            @Override
            public void onPUnsubscribe(String pattern, int subscribedChannels) {
            }

            /**
             * 初始化按表达式的方式订阅时候的处理
             * @param pattern
             * @param subscribedChannels
             */
            @Override
            public void onPSubscribe(String pattern, int subscribedChannels) {
            }

            /**
             * 取得按表达式的方式订阅的消息的处理
             * @param pattern
             * @param channel
             * @param message
             */
            @Override
            public void onPMessage(String pattern, String channel,
                                   String message) {
            }

            /**
             * 取得订阅消息后的处理
             */
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("收到消息:channel->"+message);
            }
        };
        String channel = "queue-channel";
        redis.subscribe(redisPubSub, channel);
    }
}
