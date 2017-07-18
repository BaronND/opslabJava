package app.struts.filter;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用Filterr在所有响应请求中假如Cache-Control响应头，便于前期的调试
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
