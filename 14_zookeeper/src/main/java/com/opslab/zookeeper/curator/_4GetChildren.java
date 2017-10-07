package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;

/**
 * Created by 0opslab
 */
public class _4GetChildren {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new RetryUntilElapsed(5000,1000);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(App.HOST)
                .sessionTimeoutMs(App.TIME_OUT)
                .retryPolicy(retryPolicy)
                .build();

        client.start();

        // guaranteed 保障机制，只要连接还在，就算删除失败了也回一直在后台尝试删除
        client.delete().guaranteed().deletingChildrenIfNeeded().withVersion(-1).forPath("/curator/test1");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
