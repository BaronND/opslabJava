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
 *      消息订阅者
 */
public class Subscribe implements Watcher {
    private static CountDownLatch latch =  new CountDownLatch(1);
    private static Stat stat = new Stat();
    private static ZooKeeper zk =null;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            if(Event.EventType.None == watchedEvent.getType() && watchedEvent.getPath() == null){
                latch.countDown();
            }else if(watchedEvent.getType()  == Event.EventType.NodeDataChanged){
                //Clinet需要去拉取最新的数据信息
                try {
                    byte[] newByte = zk.getData(watchedEvent.getPath(),true,stat);
                    System.out.println("path:"+watchedEvent.getPath()+"\tdata has changed.\t new Data :"+ new String(newByte));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            String path  ="/publish";
            zk =  new ZooKeeper(App.HOST,App.TIME_OUT,new Subscribe());
            latch.await();
            System.out.println("zk connection");
            byte[]  temp = zk.getData(path,true,stat);
            System.out.println("init data :pulish node data"+new String(temp));
            int i=0;
            while(true){
                Thread.sleep(Integer.MAX_VALUE);
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
