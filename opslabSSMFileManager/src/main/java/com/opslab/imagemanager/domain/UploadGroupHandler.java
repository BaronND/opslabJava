package com.opslab.imagemanager.domain;

/**
 * 上传后的处理组
 */
public class UploadGroupHandler {
    /*上传组*/
    private int gid;
    /*处理组名称*/
    private String name;
    /*处理方式*/
    private String type;
    /*处理后的文件存储路径*/
    private String path;
    /*处理数据*/
    private String handler;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
