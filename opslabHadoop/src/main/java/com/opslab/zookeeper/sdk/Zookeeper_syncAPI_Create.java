package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.Zookeeper;
import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * 在zookeeper创建目录
 */
public class Zookeeper_syncAPI_Create implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ZooKeeper zookeeper = new ZooKeeper(Zookeeper.CONNECT_INFO, 5000, new Zookeeper_syncAPI_Create());
        System.out.println(zookeeper.getState());
        connectedSemaphore.await();

        String path1 = zookeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode: " + path1);

        String path2 = zookeeper.create("/zk-test-ephemeral-", "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Success create znode: " + path2);
    }

    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}
