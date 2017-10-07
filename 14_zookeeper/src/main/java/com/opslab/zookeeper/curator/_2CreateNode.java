package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;

/**
 * Created by 0opslab
 * 创建节点
 */
public class _2CreateNode {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new RetryUntilElapsed(5000,1000);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(App.HOST)
                .sessionTimeoutMs(App.TIME_OUT)
                .retryPolicy(retryPolicy)
                .build();

        client.start();

        String path = client.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/curator","content".getBytes());
        System.out.println(path);


        String path1 = client.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/curator/test1","content".getBytes());
        System.out.println(path1);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
