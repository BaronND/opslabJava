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
    public static void main(String[] args) throws InterruptedException {
        Jedis redis = new Jedis("localhost");

        JedisPubSub redisPubSub = new JedisPubSub() {

            /**
             * 取消订阅时候的处理
             * @param channel
             * @param subscribedChannels
             */
            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                System.out.println("停用消息队列");
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
        //subscribe是一个阻塞的方法，在取消订阅该频道前，会一直阻塞在这，只有当取消了订阅才会执行下面的other code，
        // 参考上面代码，我在onMessage里面收到消息后，调用了this.unsubscribe(); 来取消订阅
        redis.subscribe(redisPubSub, channel);

        //other code



    }
}
