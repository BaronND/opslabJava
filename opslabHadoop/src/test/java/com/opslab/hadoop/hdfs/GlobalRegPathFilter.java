package com.opslab.hadoop.hdfs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

/**
 * 利用正则过滤文件名
 */
public class GlobalRegPathFilter implements PathFilter {

    private final String regex;

    public GlobalRegPathFilter(String reg){
        this.regex = reg;
    }

    public boolean accept(Path path) {
        return !path.toString().matches(regex);
    }
}
