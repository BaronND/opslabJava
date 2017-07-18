package com.opslab.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class HbaseTest {
    HBaseAdmin hBaseAdmin = null;
    HbaseDemo hbaseDemo = null;
    Configuration conf = null;

    @Before
    public void before() throws IOException {
        conf = new Configuration();
        conf.set("hbase.zookeeper.quorum", "192.168.0.100");
        conf.set("hbase.zookeeper.property.clientPort", String.valueOf(2181));

        hBaseAdmin = new HBaseAdmin(conf);
        hbaseDemo = new HbaseDemo();
    }

    @Test
    public void testCreate() throws IOException {
        String tableName = "mytable1";
        hbaseDemo.createTable(hBaseAdmin, tableName);
    }

    @Test
    public void testAddRow() {
        String tableName = "mytable1";
        String userInfo = "userInfo";
        String job = "job";

        String rowKey = "63212419990922xxxx";
        hbaseDemo.addRow(conf, tableName, rowKey, userInfo, "userId", "12345");
        hbaseDemo.addRow(conf, tableName, rowKey, userInfo, "userName", "userName");
        hbaseDemo.addRow(conf, tableName, rowKey, userInfo, "email", "userName@qq.com");
        hbaseDemo.addRow(conf, tableName, rowKey, userInfo, "organ", "公司1");

        hbaseDemo.addRow(conf, tableName, rowKey, job, "zhiwu", "后端开发");
        hbaseDemo.addRow(conf, tableName, rowKey, job, "xinzi", "10000");
        hbaseDemo.addRow(conf, tableName, rowKey, job, "zhize", "负责后端开发");


    }

    @Test
    public void getRow(){
        String tableName = "mytable1";
        String rowKey = "63212419990922xxxx";

        hbaseDemo.getRow(conf,tableName,rowKey);
    }

    @Test
    public void getAllRow() throws IOException {
        String tableName = "mytable1";
        hbaseDemo.getAllRow(conf,tableName);
    }
}
