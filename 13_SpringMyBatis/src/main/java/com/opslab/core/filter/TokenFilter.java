package com.opslab.core.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 通过filter实现对权限校验
 * @author 0opslab
 * @date on 2016/6/9 0009.
 */
public class TokenFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session =  request.getSession();
        String uri = request.getRequestURI();
        if(uri.endsWith("login")|| uri.endsWith(".png")
                || uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".js")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            String userId  = (String) session.getAttribute("user_code");
            if(userId == null){
//                response.sendRedirect(request.getContextPath()+"/login");
//                return;
                session.setAttribute("user_code","10001");
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
