package com.opslab.imagemanager.webentity;

/**
 * @author 0opslab
 * @descript 用于给前台返回统一的编码映射信息
 */
public class UiCode {
    private String id;

    private String pId;

    private String text;

    private int orderId;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UiCode() {
    }


    public UiCode(String id, String text, int orderId) {
        this.id = id;
        this.text = text;
        this.orderId = orderId;
    }

    public UiCode(String id, String pId, String text, int orderId) {
        this.id = id;
        this.pId = pId;
        this.text = text;
        this.orderId = orderId;
    }
}
