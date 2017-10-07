package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import com.opslab.zookeeper.entity.User;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * Created by monsoon on 27/09/2017.
 */
public class _2CreateNode {
    public static void main(String[] args) {
        ZkClient zk = new ZkClient(App.HOST,App.TIME_OUT);
        System.out.println("connected ok");

        String path = "/zkclient";
        if(!zk.exists(path)){
            String result_path = zk.create(path,"zkclient demo", CreateMode.PERSISTENT);
            System.out.println("创建:"+result_path);
        }




        String path1 = "/zkclient/node1";

        if(!zk.exists(path1)){
            //将数据序列化写入
            User user = new User(1001,"test","测试用户");
            String result_path1 = zk.create(path1,user, CreateMode.PERSISTENT);
            System.out.println("创建路径:"+result_path1);
        }

    }
}
