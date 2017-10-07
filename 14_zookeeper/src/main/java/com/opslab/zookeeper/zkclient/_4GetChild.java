package com.opslab.zookeeper.zkclient;

import com.opslab.zookeeper.App;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * Created by monsoon on 27/09/2017.
 */
public class _4GetChild {
    public static void main(String[] args) {
        ZkClient zk = new ZkClient(App.HOST,App.TIME_OUT);
        System.out.println("connected ok");

        List<String> children = zk.getChildren("/zkclient");
        System.out.println(children);
    }
}
