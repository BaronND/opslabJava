package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by monsoon on 22/09/2017.
 *
 */
public class _1CreateSession implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("收到事件:"+watchedEvent);
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            //连接成功
            System.out.println("to do something");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new ZooKeeper(App.HOST,App.TIME_OUT,new _1CreateSession());


        Thread.sleep(Integer.MAX_VALUE);
    }
}
