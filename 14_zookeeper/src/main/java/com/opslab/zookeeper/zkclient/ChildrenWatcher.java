package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * Created by monsoon on 27/09/2017.
 *
 */
public class ChildrenWatcher  {

    /**
     * 订阅节点的子节点变化（可以监听不存在的节点，当节点被创建的时候会收到的通知）
     */
    private static class ZKChildListener implements IZkChildListener{
        @Override
        public void handleChildChange(String s, List<String> list) throws Exception {
            System.out.println("目录发生变化");
            System.out.println(s);
            System.out.println(list);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClent = new ZkClient(App.HOST, App.TIME_OUT);
        System.out.println("connected ok");
        //订阅子节点的变化
        zkClent.subscribeChildChanges("/zkclient",new ZKChildListener());

        //创建节点
        String path = "/zkclient/childlistener-test";
        if(!zkClent.exists(path)){
            zkClent.create(path,"", CreateMode.EPHEMERAL);
        }
        Thread.sleep(10*1000);
    }

}
