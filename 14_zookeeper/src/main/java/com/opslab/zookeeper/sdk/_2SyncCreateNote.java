package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by monsoon on 22/09/2017.
 * 同步创建节点
 */
public class _2SyncCreateNote implements Watcher {

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("收到事件:" + watchedEvent);
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("成功连接到zk服务上...");

            String path = "/sync_create_node";
            try {
                //同步创建任何人可以操作的节点
                String path_result = zooKeeper.create(path, "同步创建的节点".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println("同步创建节点:" + path_result);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _2SyncCreateNote());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
