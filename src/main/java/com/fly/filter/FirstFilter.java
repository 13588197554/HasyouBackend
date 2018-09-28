package com.fly.filter;

import com.fly.util.Util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author david
 * @date 28/08/18 16:06
 */
@WebFilter(filterName = "firstFilter", urlPatterns = "/*")
public class FirstFilter implements Filter {

    private static Long START_TIME;
    private static Long END_TIME;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        StringBuffer requestURL = httpServletRequest.getRequestURL();
        System.out.println("请求的接口url : " + requestURL);

        START_TIME = Util.getCurrentTimestamp();
        chain.doFilter(request, response);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        END_TIME = Util.getCurrentTimestamp();
        System.out.println("执行了： " + (END_TIME - START_TIME) + "ms!");
    }

    @Override
    public void destroy() {

    }
}
