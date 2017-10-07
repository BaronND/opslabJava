package com.opslab.zookeeper.sdk;

import com.opslab.zookeeper.App;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * Created by monsoon on 25/09/2017.
 * 异步获取节点信息
 */
public class _5ASyncGetChildren implements Watcher{

    private static ZooKeeper zooKeeper;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(watchedEvent.getType() == Event.EventType.None && null == watchedEvent.getPath()){
            //do something
            try {
                zooKeeper.getChildren("/zookeeper", true, new IChildrenChangeCallBack(), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            if(watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
                //异步获取节点的变化信息
                zooKeeper.getChildren(watchedEvent.getPath(), true, new IChildrenChangeCallBack(), null);
            }
        }
    }

    static class IChildrenChangeCallBack implements AsyncCallback.Children2Callback{

        @Override
        public void processResult(int i, String s, Object o, List<String> list, Stat stat) {
            StringBuilder sb = new StringBuilder();
            sb.append("rc=" + i).append("\n");
            sb.append("path=" + s).append("\n");
            sb.append("ctx=" + o).append("\n");
            sb.append("children=" + list).append("\n");
            sb.append("stat=" + stat).append("\n");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(App.HOST,App.TIME_OUT,new _5ASyncGetChildren());

        Thread.sleep(Integer.MAX_VALUE);
    }
}
