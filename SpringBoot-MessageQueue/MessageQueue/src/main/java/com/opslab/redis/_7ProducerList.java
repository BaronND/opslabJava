package com.opslab.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by 0opslab
 * 利用redis的list数据格式 摸你生成-消费者模式
 */
public class _7ProducerList {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        String key = "demo.test.list";
        for (int i = 0; i < 100; i++) {
            //发送消息
            String message = "message:"+i;
            redis.lpush(key,message);
            System.out.println("发送消息->"+"Message:"+message);
        }

        redis.close();
    }
}
