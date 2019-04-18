package com.github.filter;

import javax.servlet.*;
import java.io.IOException;

public class HeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("进入HeFilter初始化方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入HeFilter方法，一切请求执行正常");
    }

    @Override
    public void destroy() {

    }
}
