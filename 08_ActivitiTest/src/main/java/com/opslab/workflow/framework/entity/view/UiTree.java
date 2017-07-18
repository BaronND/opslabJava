package com.opslab.workflow.framework.entity.view;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 主要用于将业务实体分装成前台需要的JSON数据格式
 * 只有父子接单关系，没有实际包装的格式
 *
 * @Summary： 不做Hibernate映射
 *
 */
public class UiTree {

    @JsonProperty("id")
    private String id;

    @JsonProperty("pId")
    private String pId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("attributes")
    private Map<String, String> attributes = new HashMap<String, String>();

    public UiTree() {
    }

    public UiTree(String id, String name, String pid) {
        this.id = id;
        this.pId = pid;
        this.name = name;
    }


    public UiTree(String id, String pid, String name, Map<String, String> attributes) {
        this.id = id;
        this.pId = pid;
        this.name = name;
        this.attributes = attributes;
    }


}
