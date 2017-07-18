package com.opslab.framework.base.tag;


import com.opslab.framework.base.entity.GeneralCode;
import com.opslab.framework.cache.CacheFactory;
import com.opslab.framework.cache.CommonCache;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 编码相关的JSP标签
 */
public class GeneralCodeTag extends TagSupport {
    /*编码类型*/
    private String type;

    /*编码id*/
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setCodeId(String codeId) {
        this.id = codeId;
    }

    @Override
    public int doStartTag() throws JspException {
        CommonCache cache = CacheFactory.codeCache();
        String codeNmae = cache.codeName(type, id);
        JspWriter out = super.pageContext.getOut();
        try {
            out.write(codeNmae);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TagSupport.SKIP_BODY;
    }
}
