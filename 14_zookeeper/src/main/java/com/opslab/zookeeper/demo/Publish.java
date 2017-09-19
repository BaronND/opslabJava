package com.opslab.zookeeper.demo;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by 0opslab
 * 消息发布者
 */
public class Publish {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String path = "/publish";

        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发了" + watchedEvent.getPath() + "的" + watchedEvent.getType() + "事件！");
            }
        };

        ZooKeeper zk = new ZooKeeper(App.HOST, App.TIME_OUT, watcher);
        System.out.println("zk connection");

        Stat stat = zk.exists(path, watcher);
        if (stat == null) {
            //假如节点不存在，则先创建节点
            zk.create(path, "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        for (int i = 0; i < 100; i++) {
            //向该节点发送消息
            zk.setData(path, ("hello world" +i).getBytes(), -1);
            Thread.sleep(2000);
        }



        zk.close();


    }
}
