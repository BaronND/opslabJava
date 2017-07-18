package com.opslab.zookeeper.sdk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.opslab.zookeeper.Zookeeper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class Zookeeper_Constructor_Usage_Simple implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public void process(WatchedEvent event) {
        System.out.println("Receive watched event : " + event);
        if (KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }

    public static void main(String[] args) throws IOException {
        ZooKeeper zookeeper = new ZooKeeper(Zookeeper.CONNECT_INFO, 5000, new Zookeeper_Constructor_Usage_Simple());
        System.out.println(zookeeper.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Zookeeper session established");
    }
}
