package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.Zookeeper;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Curator
 */
public class Create_session_simple {

    public static void main(String[] args){
        //使用传统方式创建session
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(Zookeeper.CONNECT_INFO, 5000, 3000, retryPolicy);
        client.start();
        System.out.println("Zookeeper session1 established. ");


        //使用fluent风格进行创建。
        CuratorFramework client1 = CuratorFrameworkFactory.builder().connectString(Zookeeper.CONNECT_INFO)
                .sessionTimeoutMs(5000).retryPolicy(retryPolicy).namespace("base").build();
        client1.start();
        System.out.println("Zookeeper session2 established. ");
    }
}
