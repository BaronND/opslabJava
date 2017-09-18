package com.opslab.zookeeper.curator;

import com.opslab.zookeeper.App;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * 创建node
 */
public class Create_node {
    private static Logger logger = Logger.getLogger(Create_node.class);

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(App.HOST)
                .sessionTimeoutMs(App.TIME_OUT).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        client.start();

        logger.debug("session connection ");


        String path ="/zk-test/book1";
        String content = "String content";
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, content.getBytes());
        logger.debug("success create znode: " + path);

        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/zk-test/book2", "String content".getBytes());
        logger.debug("success create znode: " + "/zk-test/book2");

        Stat stat = new Stat();
        String readContent = new String(client.getData().storingStatIn(stat).forPath(path));
        logger.debug("read content from path:"+readContent);

        //client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath("/zk-test/book1");
        //client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath("/zk-test/book2");


        client.close();
    }
}
