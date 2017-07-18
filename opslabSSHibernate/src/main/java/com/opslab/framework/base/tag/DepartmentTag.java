package com.opslab.framework.base.tag;


import com.opslab.framework.cache.CacheFactory;
import com.opslab.framework.cache.CommonCache;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class DepartmentTag extends TagSupport{
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int doStartTag() throws JspException {
        CommonCache cache = CacheFactory.codeCache();
        String codeNmae = cache.deptName(id);
        JspWriter out = super.pageContext.getOut();
        try {
            out.write(codeNmae);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TagSupport.SKIP_BODY;
    }
}
