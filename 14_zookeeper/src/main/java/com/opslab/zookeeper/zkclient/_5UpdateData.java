package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import com.opslab.zookeeper.entity.User;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * Created by monsoon on 27/09/2017.
 */
public class _5UpdateData {
    public static void main(String[] args) {
        ZkClient zk = new ZkClient(App.HOST,App.TIME_OUT);
        System.out.println("connected ok");




        String path1 = "/zkclient/node1";

        if(zk.exists(path1)){
            //将数据序列化写入
            User user = new User(1002,"test1","测试用户");
            zk.writeData(path1,user);
        }
    }
}
