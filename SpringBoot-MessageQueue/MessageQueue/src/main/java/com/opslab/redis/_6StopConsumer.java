package com.opslab.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by 0opslab
 */
public class _6StopConsumer {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        String channel = "queue-channel1";
        //发送消息

        redis.publish(channel, "channel-stop");

        redis.close();
    }
}
