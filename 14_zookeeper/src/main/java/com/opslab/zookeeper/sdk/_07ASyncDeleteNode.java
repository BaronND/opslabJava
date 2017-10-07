package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by monsoon on 25/09/2017.
 */
public class _07ASyncDeleteNode implements Watcher {
    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                zooKeeper.delete("/node2/node22", -1, new IDeleteCallback(), null);
            }
        }
    }

    static class IDeleteCallback implements AsyncCallback.VoidCallback {

        @Override
        public void processResult(int rc, String path, Object ctx) {
            StringBuilder sb = new StringBuilder();
            sb.append("rc=" + rc).append("\n");
            sb.append("path" + path).append("\n");
            sb.append("ctx=" + ctx).append("\n");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _7SyncDeleteNode());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
