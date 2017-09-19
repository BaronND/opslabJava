package com.opslab.zookeeper.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

/**
 * Created by 0opslab
 * 使用zookeeper连接zk服务
 */
public class ZookeeperBase {
    /**
     * 信号量，阻塞程序执行，用于等待zookeeper连接成功，发送成功信号
     */
    static final CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(App.HOST, App.TIME_OUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //获取事件的状态
                KeeperState keeperState = watchedEvent.getState();
                EventType eventType = watchedEvent.getType();
                //如果是建立连接
                if (KeeperState.SyncConnected == keeperState) {
                    if (EventType.None == eventType) {
                        //如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        connectedSemaphore.countDown();
                        System.out.println("zk 建立连接");
                    }
                }
            }
        });

        //进行阻塞
        connectedSemaphore.await();
        System.out.println("..");
        //创建父节点
        Stat exists = zk.exists("/testRoot", false);
        if(exists == null){
            zk.create("/testRoot", "testRoot".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }


        //创建子节点
        if(zk.exists("/testRoot/children", false) == null){
            String ret = zk.create("/testRoot/children", "children data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建子节点"+ret);
        }

        //获取节点洗信息
        byte[] data = zk.getData("/testRoot", false, null);
		System.out.println(new String(data));
		System.out.println(zk.getChildren("/testRoot", false));

        //修改节点的值
		zk.setData("/testRoot", "modify data root".getBytes(), -1);
		byte[] data1 = zk.getData("/testRoot", false, null);
		System.out.println(new String(data1));

        //判断节点是否存在
		System.out.println(zk.exists("/testRoot/children", false));
        //同步删除节点
        zk.delete("/testRoot/children", -1);
        //异步删除节点
        zk.delete("/testRoot/children", -1, new AsyncCallback.VoidCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx) {
                System.out.println("rc=====" + rc);
                System.out.println("path======" + path);
                System.out.println("ctc======" + path);
            }
        }, "回调值");
		System.out.println(zk.exists("/testRoot/children", false));

        zk.close();

    }

}
