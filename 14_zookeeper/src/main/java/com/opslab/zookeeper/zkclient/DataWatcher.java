package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * Created by 0opslab
 */
public class DataWatcher {

    private static class DataListener implements IZkDataListener{

        @Override
        public void handleDataChange(String s, Object o) throws Exception {
            System.out.println("数据发生变化:"+s+"=>"+o);
        }

        @Override
        public void handleDataDeleted(String s) throws Exception {
            System.out.println("数据发生变化:"+s);
        }

        public static void main(String[] args) throws InterruptedException {
            ZkClient zk = new ZkClient(App.HOST, App.TIME_OUT);
            System.out.println("connected ok");
            //订阅子节点的变化
            zk.subscribeDataChanges("/zkclient",new DataListener());

            //更新节点数据
            zk.writeData("/zkclient","update data");
            Thread.sleep(10*1000);
        }
    }
}
