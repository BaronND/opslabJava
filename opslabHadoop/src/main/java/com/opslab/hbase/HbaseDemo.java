package com.opslab.hbase;

import com.sun.tools.javac.util.Name;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 一些hbase的基本操作
 */
public class HbaseDemo {
    private static Logger logger = Logger.getLogger(HbaseDemo.class);

    /**
     * 创建表
     * @param hbsa
     * @return
     * @throws IOException
     */
    public boolean createTable(HBaseAdmin hbsa,String tableName) throws IOException {
        if(hbsa.tableExists(tableName)){
            logger.error("table is exist!");
            return false;
        }

        logger.info("well create table");
        HTableDescriptor table = new HTableDescriptor(tableName);
        table.addFamily(new HColumnDescriptor("userInfo"));
        table.addFamily(new HColumnDescriptor("job"));


        try{
            hbsa.createTable(table);
            return true;
        }catch (IOException e){
            logger.error("create table error:"+e.getMessage());
        }
        return false;
    }

    /**
     * 删除表
     * @param hbsa
     * @param tableName
     * @return
     */
    public boolean deleteTable(HBaseAdmin hbsa,String tableName) throws IOException {
        if(hbsa.tableExists(tableName)){
            try{
                hbsa.disableTable(tableName);
                hbsa.deleteTable(tableName);
                return true;
            }catch (Exception e){
                logger.error("delete table error:"+tableName+",message:"+e.getMessage());
                return false;
            }

        }else{
            logger.error("table it's exist:"+tableName);
            return false;
        }
    }

    /**
     * 新增一行
     * @param conf
     * @param row
     * @param tableName
     * @param columnFamily
     * @param column
     * @param value
     * @return
     */
    public boolean addRow(Configuration conf,String tableName,String row,String columnFamily,String column,String value){
        try {
            HTable table = new HTable(conf,tableName);
            //row
            Put put = new Put(Bytes.toBytes(row));
            //设置列族、列、值
            put.add(Bytes.toBytes(columnFamily),Bytes.toBytes(column),Bytes.toBytes(value));
            table.put(put);
            return true;
        } catch (IOException e) {
            logger.error("add row error:"+tableName+"{"+columnFamily+":"+column+":"+value+"}");
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 删除一行
     * @param conf
     * @param tableName
     * @param row
     * @return
     */
    public boolean delRow(Configuration conf,String tableName,String row){
        try {
            HTable table = new HTable(conf,tableName);
            Delete del = new Delete(Bytes.toBytes(row));
            table.delete(del);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除多行
     * @param conf
     * @param tableName
     * @param rows
     */
    public void delRows(Configuration conf,String tableName,String[] rows){
        if(rows == null || rows.length == 0){
            return;
        }
        try {
            HTable table = new HTable(conf,tableName);
            List<Delete> deletes = new ArrayList<Delete>();
            for(String row:rows){
                deletes.add(new Delete(Bytes.toBytes(row)));
            }
            table.delete(deletes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一行数据
     * @param conf
     * @param tableName
     * @param rowKey
     */
    public void getRow(Configuration conf,String tableName,String rowKey){
        try {
            HTable table = new HTable(conf,tableName);
            Get get = new Get(Bytes.toBytes(rowKey));

            Result result = table.get(get);
            for(KeyValue rowKV:result.raw()){
                System.out.println("行名:"+new String(rowKV.getRow()));
                System.out.println("时间:"+rowKV.getTimestamp());
                System.out.println("列族名:"+new String(rowKV.getFamily()));
                System.out.println("列名:"+new String(rowKV.getQualifier()));
                System.out.println("值:"+new String(rowKV.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取全部的数据
     * @param conf
     * @param tableName
     */
    public void getAllRow(Configuration conf,String tableName) throws IOException {
        HTable table = new HTable(conf,tableName);
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        for(Result result:scanner){
            for(KeyValue keyValue:result.raw()){
                System.out.println("行名:"+new String(keyValue.getRow()));
                System.out.println("时间:"+keyValue.getTimestamp());
                System.out.println("列族名:"+new String(keyValue.getFamily()));
                System.out.println("列名:"+new String(keyValue.getQualifier()));
                System.out.println("值:"+new String(keyValue.getValue()));
            }
        }

    }

}
