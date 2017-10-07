package com.opslab.zookeeper.master;

import java.io.Serializable;

/**
 * Created by 0opslab
 * master选举描述workder server的基本信息
 */
public class RunningData implements Serializable{
    private static final long serialVersionUID = 1263577459043203630L;

    private Long cid;
    private String name;

    public RunningData() {
    }

    public RunningData(Long cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
