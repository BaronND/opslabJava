package com.opslab.hadoop.hdfs;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;


public class HDFS {
    // HDFS操作入口
    public FileSystem fs = null;

    private static Logger logger = Logger.getLogger(HDFS.class);

    /**
     * 前置方法描述：创建fileSystem对象
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        URI uri = new URI("hdfs://192.168.0.100:9000");
        Configuration configuration = new Configuration();
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");

        fs = FileSystem.get(uri, configuration, "root");
    }

    /**
     * 实例正则匹配目录下的文件
     */
    public FileStatus[]  globListFileReg(Path path, String reg) throws IOException {
        return fs.globStatus(path, new GlobalRegPathFilter(reg));

    }
    /**
     * 关闭文件系统
     * @throws IOException
     */
    @After
    public void clean() throws IOException {
        if(fs != null){
            fs.close();
        }
    }

    /**
     * 删除文件
     * @param file     文件路径
     * @param recursive 是否递归删除
     * @throws Exception
     */
    public void rm(String file, boolean recursive) throws Exception {
        Path path = new Path(file);
        if (!fs.delete(path, recursive)) {
            logger.error("Delete path " + file + " failed.");
        }
    }

    /**
     * 创建目录
     * @param dir
     * @throws Exception
     */
    public void mkdirs(String dir) throws Exception {
        Path path = new Path(dir);
        if (!fs.exists(path)) {
            if (!fs.mkdirs(path)) {
                logger.error("Create dir " + path.toString() + " failed.");
            }
        } else {
            logger.info(dir + " already exists.");
        }
    }



    /**
     * 列出所有文件
     * @param path 路径
     * @throws IOException
     */
    public List<Path> listFile(Path path) throws IOException {
        List<Path> list = new ArrayList<Path>();
        FileStatus[] listStatus = fs.listStatus(path);
        for (FileStatus fileStatus : listStatus) {
            Path pa = fileStatus.getPath();
            if(fs.isDirectory(pa)){
                list.addAll(listFile(pa));
            }else{
                list.add(pa);
            }
        }
        return list;
    }

    /**
     * 创建文件
     * @param file  文件路径
     * @param content   文件内容
     * @param overwrite 是否重写
     * @throws Exception
     */
    public void createFile(String file, String content, boolean overwrite) throws Exception {
        byte[] buff = content.getBytes();
        FSDataOutputStream os = null;
        try {
            os = fs.create(new Path(file), overwrite);
            os.write(buff, 0, buff.length);
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public void fileStatus(FileStatus fst){
        System.out.println("目录路径：" + fst.getPath());
        System.out.println("目录长度：" + fst.getLen());
        System.out.println("目录修改日期：" + fst.getModificationTime());
        System.out.println("上次目录访问日期：" + fst.getAccessTime());
        System.out.println("目录备份数：" + fst.getReplication());
        System.out.println("目录块大小：" + fst.getBlockSize());
        System.out.println("目录所有者：" + fst.getOwner());
        System.out.println("目录所在分组：" + fst.getGroup());
        System.out.println("目录权限：" + fst.getPermission().toString());
    }

    /**
     * 文件重命名
     * @param src
     * @param dest
     */
    public boolean rename(String src,String dest) throws IOException {
        return  fs.rename(new Path(src), new Path(dest));
    }
}
