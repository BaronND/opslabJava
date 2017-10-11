package com.opslab.redis;

import com.opslab.util.JacksonUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by 0opslab
 * 利用redis的list数据格式 摸你生成-消费者模式
 */
public class _8ConsumerList {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        String key = "demo.test.list";
        while(true){
            //发送消息
            List<String> messages = redis.brpop(5000,key);
            if(messages != null){
                System.out.println("收到消息:"+ JacksonUtil.toJSON(messages));
            }

        }
    }
}
