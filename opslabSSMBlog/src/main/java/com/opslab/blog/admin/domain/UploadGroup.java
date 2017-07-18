package com.opslab.blog.admin.domain;

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


}
