package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import com.opslab.zookeeper.entity.User;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.data.Stat;

/**
 * Created by monsoon on 27/09/2017.
 */
public class _3GetData {
    public static void main(String[] args) {
        ZkClient zk = new ZkClient(App.HOST,App.TIME_OUT);
        System.out.println("connected ok");


        String data = zk.readData("/zkclient");
        System.out.println("/zkclient data:"+data);


        User user = zk.readData("/zkclient/node1");
        System.out.println(user);

        Stat stat = new Stat();
        User user1 = zk.readData("/zkclient/node1",stat);
        System.out.println(user1);
        System.out.println(stat);
    }
}
