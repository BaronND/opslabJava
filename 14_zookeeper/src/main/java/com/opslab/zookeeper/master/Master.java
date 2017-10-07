package com.opslab.zookeeper.master;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

/**
 * Created by 0opslab
 * master
 */
public class Master {

    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient(App.HOST, App.TIME_OUT, App.TIME_OUT, new SerializableSerializer());

        //创建serverData
        RunningData runningData = new RunningData(Long.valueOf(100), "master");
        //创建服务
        WorkServer workServer = new WorkServer(runningData);
        workServer.setZkClient(zkClient);


        workServer.startServer();

        Thread.sleep(Integer.MAX_VALUE);
    }
}
