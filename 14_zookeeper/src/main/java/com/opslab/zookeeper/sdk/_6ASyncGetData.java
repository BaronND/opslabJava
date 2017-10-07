package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by monsoon on 25/09/2017.
 * 异步获取节点数据
 */
public class _6ASyncGetData implements Watcher{

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                zooKeeper.getData(watchedEvent.getPath(), true, new IDataCallback(), null);
            } else {
                if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    try {
                        zooKeeper.getData(watchedEvent.getPath(), true, new IDataCallback(), null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class IDataCallback implements AsyncCallback.DataCallback{

        @Override
        public void processResult(int i, String path, Object o, byte[] bytes, Stat stat) {
            try {
                System.out.println(new String(zooKeeper.getData(path, true, stat)));
                System.out.println("stat:" + stat);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _6ASyncGetData());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
