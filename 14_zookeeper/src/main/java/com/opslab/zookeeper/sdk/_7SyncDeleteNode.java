package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by monsoon on 25/09/2017.
 * 同步删除节点
 */
public class _7SyncDeleteNode implements Watcher{
    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                try {
                    // -1表示不校验版本信息
                    zooKeeper.delete("/zookeeper/zk-test-ephemeral-3", -1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _7SyncDeleteNode());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
