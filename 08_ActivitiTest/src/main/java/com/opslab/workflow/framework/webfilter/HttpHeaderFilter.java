package com.opslab.workflow.framework.webfilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过filter统一对http头信息做处理
 * @author 0opslab
 * @date on 2016/6/9 0009.
 */
public class HttpHeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse reponse = (HttpServletResponse ) servletResponse;
        reponse.setHeader("Cache-Control","no-cache");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
