package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * Created by monsoon on 27/09/2017.
 */
public class _6DeleteNode  {
    public static void main(String[] args) {
        ZkClient zk = new ZkClient(new ZkConnection(App.HOST), App.TIME_OUT);
        System.out.println("connected ok");

//        boolean delete = zk.delete("/zkclient/node1");
//        System.out.println("删除结果："+delete);
    }
}
