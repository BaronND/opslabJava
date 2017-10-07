package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by monsoon on 25/09/2017.
 * 异步创建节点
 */
public class _3ASyncCreateNode implements Watcher{
    private static ZooKeeper zookeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("收到事件："+watchedEvent);
        if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
            //异步创建节点
            zookeeper.create("/async_node","异步节点".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT,new IStringCallback(),"异步创建");
        }
    }

    static class IStringCallback implements AsyncCallback.StringCallback{

        /**
         * @param i
         *            返回码0表示成功
         * @param s
         *            我们需要创建的节点的完整路径
         * @param o
         *            上面传入的值("创建")
         * @param s1
         *            服务器返回给我们已经创建的节点的真实路径,如果是顺序节点path和name是不一样的
         */
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            StringBuilder sb = new StringBuilder();
            sb.append("创建结果=" + i).append("\n");
            sb.append("创建路径path=" + s).append("\n");
            sb.append("备注信息=" + o).append("\n");
            sb.append("真实路径=" + s1);
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        zookeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _3ASyncCreateNode());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
