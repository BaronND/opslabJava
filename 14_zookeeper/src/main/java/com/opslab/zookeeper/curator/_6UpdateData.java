package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.data.Stat;

/**
 * Created by 0opslab
 */
public class _6UpdateData {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new RetryUntilElapsed(5000,1000);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(App.HOST)
                .sessionTimeoutMs(App.TIME_OUT)
                .retryPolicy(retryPolicy)
                .build();

        client.start();


        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/node1");

        client.setData().withVersion(stat.getVersion()).forPath("/node1", "111".getBytes());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
