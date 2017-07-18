package com.opslab.hadoop.hdfs;

import com.opslab.hadoop.hdfs.HDFS;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by neptune on 2016/12/22 0022.
 */
public class hdfsDemo1 extends HDFS {


    @Test
    public void listFile() throws IOException {
        List<Path> paths = listFile(new Path("/"));
        for(Path path:paths){
            System.out.println(path);
        }

    }



    @Test
    /**
     * 测试写文件
     */
    public void testWrite() throws IOException {
        String path ="/test/test1.txt";
        FSDataOutputStream hdfsOutStream = fs.create(new Path(path));
        hdfsOutStream.writeChars("hello");
        hdfsOutStream.close();
    }

    @Test
    public void testWrite1() throws Exception {
        String path ="/test/test2.txt";
        createFile(path,"hello world",false);
    }

    @Test
    public void testRename() throws IOException {
        String path ="/test/test2.txt";
        String dest = "/test/test2_bak.txt";
        rename(path,dest);
    }

    @Test
    public void testRead() throws IOException {
        String path ="/test/test1.txt";
        FSDataInputStream hdfsInStream = fs.open(new Path(path));
        ByteArrayOutputStream out =  new ByteArrayOutputStream();
        IOUtils.copyBytes(hdfsInStream, out, 2048, true);
        System.out.println(new String(out.toByteArray()));
        hdfsInStream.close();
    }
    @Test
    public void mkdirs() throws Exception {
        String dir ="/test/testdir/";
        mkdirs(dir);
    }

    @Test
    public void FileStatus() throws IOException {
        //测试获取一些文件及目录的属性
        String dir ="/test/testdir";
        FileStatus fst = fs.getFileStatus(new Path(dir));
        fileStatus(fst);

        fileStatus(fs.getFileStatus(new Path("/test/test1.txt")));
    }

    @Test
    public void copyLocalFileToHDFS() throws IOException {
        //copy local file to hdfs filesystem
        String src ="target/";
        String desct="/test/copyfile/target";
        fs.copyFromLocalFile(new Path(src),new Path(desct));
    }





    @Test
    public void globList() throws IOException {
        FileStatus[] fileStatuses = globListFileReg(new Path("/test/*/"), "\\*.class$");
        for(FileStatus fs:fileStatuses){
            System.out.println(fs.getPath());
        }
    }
}
