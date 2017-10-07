package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by monsoon on 27/09/2017.
 */
public class _1CreateSession {
    public static void main(String[] args) {
//        ZkClient是Github上一个开源的ZooKeeper客户端。
//        ZkClient在ZooKeeper原生 API接口之上进行了包装，是一个更加易用的ZooKeeper客户端。
//        同时，ZkClient在内部实现了诸如Session超时重连、Watcher反复注册等功能。
        ZkClient zk = new ZkClient(App.HOST,App.TIME_OUT);
        System.out.println("connected ok");
    }
}
