package com.opslab.workflow.framework.entity.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 0opslab
 * @date on 2016/4/21 0021.
 */
public class UiPTree {
    @JsonProperty("id")
    private String id;

    @JsonProperty("pId")
    private String pId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("attributes")
    private Map<String, String> attributes = new HashMap<String, String>();

    private List<UiPTree> child = new ArrayList<>();

    public UiPTree() {
    }

    public UiPTree(String id, String name, String pid) {
        this.id = id;
        this.pId = pid;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UiPTree(String id, String pid, String name, Map<String, String> attributes) {
        this.id = id;
        this.pId = pid;
        this.name = name;
        this.attributes = attributes;
    }

    public void addChild(UiPTree tree){
        child.add(tree);
    }

}
