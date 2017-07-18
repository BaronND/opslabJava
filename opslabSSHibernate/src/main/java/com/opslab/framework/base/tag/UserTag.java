package com.opslab.framework.base.tag;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * 用户相关的标签
 */
public class UserTag extends TagSupport{

    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
