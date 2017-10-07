package com.opslab.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by 0opslab
 * 利用redis实现消息队列
 */
public class _3Producer {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        String channel = "queue-channel";
        for (int i = 0; i < 100; i++) {
            //发送消息
            redis.publish(channel,"Message:"+i);
            System.out.println("发送消息->"+"Message:"+i);
        }

        redis.close();
    }
}
