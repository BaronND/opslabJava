package com.opslab.redis;

import com.opslab.entity.UserInfo;
import com.opslab.util.JacksonUtil;
import redis.clients.jedis.Jedis;

/**
 * Created by 0opslab
 */
public class _5ProducerBean {
    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        String channel = "queue-channel1";
        for (int i = 0; i < 100; i++) {
            //发送消息
            UserInfo userInfo = new UserInfo(Long.valueOf(i),"user-"+i,"UserName-"+i,"useremail"+i+"@gmail.com");
            String message = JacksonUtil.toJSON(userInfo);
            redis.publish(channel, message);
            System.out.println("发送消息->"+"Message:"+message);
        }

        redis.close();
    }
}
