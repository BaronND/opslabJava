package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryUntilElapsed;

import java.util.List;

/**
 * Created by 0opslab
 */
public class _3DelNode {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new RetryUntilElapsed(5000,1000);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(App.HOST)
                .sessionTimeoutMs(App.TIME_OUT)
                .retryPolicy(retryPolicy)
                .build();

        client.start();

        List<String> cList = client.getChildren().forPath("/node1");

        System.out.println(cList.toString());
    }
}
