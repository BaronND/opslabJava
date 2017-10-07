package com.opslab.redis;

import com.opslab.entity.UserInfo;
import com.opslab.util.JacksonUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.io.IOException;

/**
 * Created by 0opslab
 */
public class _6ConsumerBean {
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
                try {
                    UserInfo userinfo = (UserInfo)JacksonUtil.toObject(message, UserInfo.class);
                    System.out.println("消息转换成Object："+userinfo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        String channel = "queue-channel1";
        redis.subscribe(redisPubSub, channel);
    }
}
