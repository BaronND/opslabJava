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
 * 同步修改节点数据
 */
public class _6SyncUpdateNode implements Watcher{
    private static ZooKeeper zooKeeper;
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {

            try {
                Stat stat = zooKeeper.setData("/zookeeper", "123".getBytes(), -1);
                System.out.println("stat:" + stat);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(App.HOST, App.TIME_OUT, new _6SyncUpdateNode());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
