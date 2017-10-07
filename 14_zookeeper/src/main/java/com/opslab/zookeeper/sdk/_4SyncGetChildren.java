package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * Created by monsoon on 25/09/2017.
 * 同步获取节点信息
 */
public class _4SyncGetChildren implements Watcher{

    private static ZooKeeper zookeeper;


    @Override
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            // 保证客户端与服务端建立连接后 Dosomething的内容只执行一次
            if (watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()) {
                try {
                    // 返回节点下面的所有子节点的列表
                    // true false 要不要关注这个节点的子节点的变化
                    List<String> children = zookeeper.getChildren("/zookeeper", true);
                    System.out.println(children);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // doSomething 有关注节点的变化
                if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                    System.out.println("目录:/zookeeper发生变化");
                    try {
                        System.out.println(zookeeper.getChildren(watchedEvent.getPath(), true));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        zookeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _4SyncGetChildren());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
