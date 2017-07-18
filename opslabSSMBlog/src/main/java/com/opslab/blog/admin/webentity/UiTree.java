package com.opslab.blog.admin.webentity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    private String treeType;

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

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
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

    public UiTree(String id, String pId, String text,String treeType) {
        this.id = id;
        this.pId = pId;
        this.text = text;
        this.treeType = treeType;
    }

    public UiTree(int id, int pId, String text,String treeType) {
        this.id = String.valueOf(id);
        this.pId = String.valueOf(pId);
        this.text = text;
        this.treeType = treeType;
    }
}
