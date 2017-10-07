package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;

/**
 * Created by 0opslab
 */
public class _1CreateSession {
    public static void main(String[] args) {
        //ZkClient是Github上一个开源的ZooKeeper客户端。
        //ZkClient在ZooKeeper原生 API接口之上进行了包装，是一个更加易用的ZooKeeper客户端。
        //同时，ZkClient在内部实现了诸如Session超时重连、Watcher反复注册等功能。


        // retryPolicy 重试策略

        // 刚开始的重试事件是1000，后面一直增加，最多不超过三次
        // RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        // 最多重试5次，每次停顿1000ms
        // RetryPolicy retryPolicy = new RetryNTimes(5, 1000);

        // 重试过程不能超过5000ms，每次间隔1000s
        RetryPolicy retryPolicy = new RetryUntilElapsed(5000, 1000);

        // 常规风格
        // CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.105:2181",5000,5000, retryPolicy);


        // Fluent风格
        CuratorFramework client = CuratorFrameworkFactory
                .builder()
                .connectString(App.HOST)
                .sessionTimeoutMs(App.TIME_OUT)
                .connectionTimeoutMs(App.TIME_OUT)
                .retryPolicy(retryPolicy)
                .build();

        client.start();

        System.out.println("conneted ok!");
    }
}
