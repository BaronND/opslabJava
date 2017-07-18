package com.opslab.imagemanager.webentity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @date on 2016/4/21 0021.
 */
public class UiTree {
    private String id;

    private String pId;

    private String text;

    private Map<String, String> attributes = new HashMap<String, String>();

    private List<UiTree> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<UiTree> getChildren() {
        return children;
    }

    public void setChildren(List<UiTree> children) {
        this.children = children;
    }

    public void addChildren(UiTree tree){
        children.add(tree);
    }

    public UiTree(String id, String pId, String text) {
        this.id = id;
        this.pId = pId;
        this.text = text;
    }


}
