package com.opslab.zookeeper.master;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkException;
import org.I0Itec.zkclient.exception.ZkInterruptedException;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 0opslab
 * 选举工作类
 */
public class WorkServer {
    /*、服务器是否在运行*/
    private volatile boolean running = false;

    private ZkClient zkClient;

    /*主节点路径*/
    private static final String MASTER_PATH = "/master";

    /*订阅节点的子节点内容的变化*/
    private IZkDataListener dataListener;

    /*从节点*/
    private RunningData serverData;

    /*主节点*/
    private RunningData masterData;

    /** 延迟执行 */
    private ScheduledExecutorService delayExector = Executors.newScheduledThreadPool(1);
    // private int delayTime = 5;


    public WorkServer(RunningData runningData) {
        this.serverData = runningData;
        this.dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                getMaster();
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        };
    }

    public ZkClient getZkClient() {
        return zkClient;
    }

    public void setZkClient(ZkClient zkClient) {
        this.zkClient = zkClient;
    }

    /**
     * 检查是否是master
     * @return
     */
    private boolean checkIsMaster(){
        try {
            RunningData eventData = zkClient.readData(MASTER_PATH);
            masterData = eventData;
            if (masterData.getName().equals(serverData.getName())) {
                return true;
            }
            return false;
        } catch (ZkNoNodeException e) {
            return false;
        } catch (ZkInterruptedException e) {
            return checkIsMaster();
        } catch (ZkException e) {
            return false;
        }
    }

    /**
     * 释放master
     */
    private void releaseMaster(){
        if(checkIsMaster()){
            zkClient.delete(MASTER_PATH);
        }
    }

    public void startServer() throws Exception {
        System.out.println(this.serverData.getName()+" IS START");
        if(running){
            throw new Exception("server has startup...");
        }

        running = true;
        //删除订阅事件
        zkClient.subscribeDataChanges(MASTER_PATH,dataListener);

        getMaster();
    }

    /**
     * 争抢master节点
     */
    private void getMaster(){
        if(!running){
            return;
        }
        try {
            // 创建临时节点
            String s = zkClient.create(MASTER_PATH, serverData, CreateMode.EPHEMERAL);
            masterData = serverData;
            System.out.println(serverData.getName() + " is master");

            // 测试: 5s后判断是否是master节点,是的话 释放master节点
            // 释放后,其他节点都是有监听删除事件的,会争抢master
            delayExector.schedule(new Runnable() {
                public void run() {
                    if (checkIsMaster()) {
                        releaseMaster();
                    }
                }
            }, 5, TimeUnit.SECONDS);

        } catch (ZkNodeExistsException e) {
            RunningData runningData = zkClient.readData(MASTER_PATH, true);
            if (runningData == null) {
                getMaster();
            } else {
                masterData = runningData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 关闭服务器
     * @throws Exception
     */
    public void stop() throws Exception {
        if(!running){
            throw new Exception("server has stoped");
        }
        running = false;

        delayExector.shutdown();

        //取消订阅删除时间
        zkClient.unsubscribeDataChanges(MASTER_PATH,dataListener);

        releaseMaster();
    }
}
