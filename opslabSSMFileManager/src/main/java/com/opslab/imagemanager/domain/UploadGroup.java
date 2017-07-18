package com.opslab.imagemanager.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 上传配置组
 */
public class UploadGroup {
    /*上传组id*/
    private int gid;
    /*上传组名称*/
    private String name;
    /*可上传文件的后缀组 .png,.jpe*/
    private String suffixs;
    /*保存基础目录*/
    private String path;
    /*源文件保存的记录*/
    private String originalPath;
    /*文件的最大限制*/
    private int limit;
    /*可以上传的客户端ip*/
    private List<UploadGroupClient> clients = new ArrayList<>();
    /*处理组*/
    private List<UploadGroupHandler> handlers = new ArrayList<>();


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

    public String getSuffixs() {
        return suffixs;
    }

    public void setSuffixs(String suffixs) {
        this.suffixs = suffixs;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<UploadGroupClient> getClients() {
        return clients;
    }

    public void setClients(List<UploadGroupClient> clients) {
        this.clients = clients;
    }

    public List<UploadGroupHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<UploadGroupHandler> handlers) {
        this.handlers = handlers;
    }
}
