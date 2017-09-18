package com.opslab.zookeeper.demo;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by 0opslab
 * 消息发布者
 */
public class Publish implements Watcher {
    private static CountDownLatch latch =  new CountDownLatch(1);
    private static Stat stat = new Stat();
    private static ZooKeeper zk =null;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            System.out.println("receive watched event:"+watchedEvent);
            System.out.println(watchedEvent.getState());
            latch.countDown();
        }
    }


    public static void main(String[] args) {
        try {
            String path  ="/publish";
            zk =  new ZooKeeper(App.HOST,App.TIME_OUT,new Publish());
            latch.await();
            System.out.println("zk connection");
            byte[]  temp = zk.getData(path,true,stat);
            System.out.println("init data :pulish node data"+new String(temp));
            int i=0;
            while(true){
                System.out.println( "publish new Data:"+i);
                zk.setData(path,String.valueOf(i).getBytes(),-1);
                Thread.sleep(5000L);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
