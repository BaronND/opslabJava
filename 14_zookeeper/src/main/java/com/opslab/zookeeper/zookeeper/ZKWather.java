package com.opslab.zookeeper.zookeeper;
import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by monsoon on 21/09/2017.
 */
public class ZKWather implements Watcher {

    /** zk变量 */
    private ZooKeeper zk = null;

    /** 父节点path */
    static final String PARENT_PATH = "/super";

    /** 信号量设置，用于等待zookeeper连接建立之后 通知阻塞程序继续向下执行 */
    private CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public ZKWather(String host,int timeOut) throws IOException, InterruptedException {
        zk = new ZooKeeper(host, timeOut, this);
        System.out.println("开始连接ZK服务器");
        connectedSemaphore.await();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
       //连接状态
        Event.KeeperState keeperState = watchedEvent.getState();

        //事件类型
        Event.EventType eventType = watchedEvent.getType();

        //触发的路径
        String path = watchedEvent.getPath();

        if (Event.KeeperState.SyncConnected == keeperState) {
            // 成功连接上ZK服务器
            if (EventType.None == eventType) {
                System.out.println("成功连接上ZK服务器");
                connectedSemaphore.countDown();
                try {
                    if(this.zk.exists(PARENT_PATH, false) == null){
                        this.zk.create(PARENT_PATH, "root".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                    }
                    List<String> paths = this.zk.getChildren(PARENT_PATH, true);
                    for (String p : paths) {
                        System.out.println(p);
                        this.zk.exists(PARENT_PATH + "/" + p, true);
                    }
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //创建节点
            else if (EventType.NodeCreated == eventType) {
                System.out.println("节点创建");
                try {
                    this.zk.exists(path, true);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //更新节点
            else if (EventType.NodeDataChanged == eventType) {
                System.out.println("节点数据更新");
                try {
                    //update nodes  call function
                    this.zk.exists(path, true);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //更新子节点
            else if (EventType.NodeChildrenChanged == eventType) {
//                System.out.println("子节点 ... 变更");
//                try {
//                    List<String> paths = this.zk.getChildren(path, true);
//                    if(paths.size() >= cowaList.size()){
//                        paths.removeAll(cowaList);
//                        for(String p : paths){
//                            this.zk.exists(path + "/" + p, true);
//                            //this.zk.getChildren(path + "/" + p, true);
//                            System.out.println("这个是新增的子节点 : " + path + "/" + p);
//                            //add new nodes  call function
//                        }
//                        cowaList.addAll(paths);
//                    } else {
//                        cowaList = paths;
//                    }
//                    System.out.println("cowaList: " + cowaList.toString());
//                    System.out.println("paths: " + paths.toString());
//
//                } catch (KeeperException | InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            //删除节点
            else if (EventType.NodeDeleted == eventType) {
                System.out.println("节点 " + path + " 被删除");
                try {
                    //delete nodes  call function
                    this.zk.exists(path, true);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else ;
        }
        else if (KeeperState.Disconnected == keeperState) {
            System.out.println("与ZK服务器断开连接");
        }
        else if (KeeperState.AuthFailed == keeperState) {
            System.out.println("权限检查失败");
        }
        else if (KeeperState.Expired == keeperState) {
            System.out.println("会话失效");
        }else{
            System.out.println("未知的状态");
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        ZKWather zkWather = new ZKWather(App.HOST, App.TIME_OUT);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
