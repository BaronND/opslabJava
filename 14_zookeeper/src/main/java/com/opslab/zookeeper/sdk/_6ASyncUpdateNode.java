package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Created by monsoon on 25/09/2017.
 * 异步修改节点数据
 */
public class _6ASyncUpdateNode implements Watcher{

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                zooKeeper.setData("/zookeeper", "234".getBytes(), -1, new IStatCallback(), null);
            }
        }
    }

    static class IStatCallback implements AsyncCallback.StatCallback {

        @Override
        public void processResult(int rc, String path, Object ctx, Stat stat) {
            StringBuilder sb = new StringBuilder();
            sb.append("rc=" + rc).append("\n");
            sb.append("path" + path).append("\n");
            sb.append("ctx=" + ctx).append("\n");
            sb.append("Stat=" + stat).append("\n");
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) throws InterruptedException, IOException {
        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _6ASyncUpdateNode());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
