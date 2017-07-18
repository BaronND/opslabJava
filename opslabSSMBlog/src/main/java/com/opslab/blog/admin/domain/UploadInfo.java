package com.opslab.blog.admin.domain;

import com.opslab.blog.admin.constant.UploadInfoStatus;

import java.util.Date;

/**
 * 上传记录
 */
public class UploadInfo {
    /*主键*/
    private String id;
    //上传图像的用户组
    private int gid;
    //业务系统主键
    private String bid;
    //创建时间
    private Date createTime;
    //原始名称
    private String oldName;
    //上传后的文件名
    private String newName;
    //当前状态
    private UploadInfoStatus status;
    //文件的状态说明
    private String statusMsg;
    //文件路径
    private String path;
    //文件的md5值
    private String md5;
    //文件的sha1
    private String sha1;
    //文件大小
    private long size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public UploadInfoStatus getStatus() {
        return status;
    }

    public void setStatus(UploadInfoStatus status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public UploadInfo() {
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public UploadInfo(String id, int gid, String bid, String oldName, String newName, UploadInfoStatus status, String statusMsg,
                      String path, String md5, String sha1, long size) {
        this.createTime = new Date();
        this.id = id;
        this.gid = gid;
        this.bid = bid;
        this.oldName = oldName;
        this.newName = newName;
        this.status = status;
        this.statusMsg = statusMsg;
        this.path = path;
        this.md5 = md5;
        this.sha1 = sha1;
        this.size = size;
    }
}
