package com.opslab.framework.base.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setAttribute("contextPath",request.getContextPath());
        HttpServletResponse reponse = (HttpServletResponse ) servletResponse;
        reponse.setHeader("Cache-Control","no-cache");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
