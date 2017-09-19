package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import java.util.List;

public class ZkClientBase {

    public static void main(String[] args) throws Exception {
        ZkClient zkc = new ZkClient(new ZkConnection(App.HOST), App.TIME_OUT);
        //1. create and delete方法
        if (!zkc.exists("/zkclient")) {
            zkc.createPersistent("/zkclient");
        }
        zkc.createEphemeral("/zkclient/temp");
        zkc.createPersistent("/zkclient/super/c1", true);
        Thread.sleep(1000);
        zkc.delete("/zkclient/temp");
        zkc.deleteRecursive("/zkclient/super");

        //2. 设置path和data 并且读取子节点和每个节点的内容
        zkc.createPersistent("/zkclient/super", "1234");
        zkc.createPersistent("/zkclient/super/c1", "c1内容");
        zkc.createPersistent("/zkclient/super/c2", "c2内容");
        List<String> list = zkc.getChildren("/zkclient/super");
        for (String p : list) {
            String rp = "/zkclient/super/" + p;
            String data = zkc.readData(rp);
            System.out.println("节点为：" + rp + "，内容为: " + data);
        }

        //3. 更新和判断节点是否存在
        zkc.writeData("/zkclient/super/c1", "新内容");
        String readData = zkc.readData("/zkclient/super/c1");
        System.out.println(readData);

        //4.递归删除/super内容
//		zkc.deleteRecursive("/super");		
    }
}
