package com.opslab.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by 0opslab
 * 使用Jedis简单的连接
 */
public class _1ConnectionRedis {

    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        redis.set("test-key","test-value");

        String value = redis.get("test-key");
        System.out.println("key-value:"+value);

    }
}
