package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by monsoon on 25/09/2017.
 * 同步获取节点数据
 */
public class _6SyncGetData implements Watcher{
    private static ZooKeeper zooKeeper;

    private static Stat stat = new Stat();

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {

            try {
                // true false 要不要关注这个节点的子节点的变化
                String content = new String(zooKeeper.getData("/zookeeper", true, stat));
                System.out.println("data content1:"+content);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                try {
                    String content = new String(zooKeeper.getData("/zookeeper", true, stat));
                    System.out.println("data content1:"+content);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _6SyncGetData());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
