package top.soft.class06filterlistener.filter;

import jakarta.servlet.*;

import java.io.IOException;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;

/**
 * @author lhy
 * @description: TODO
 * @date 2024/11/23 13:38
 */

//@WebFilter("/*")
public class FilterDemo01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.print("初始化");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行资源之前执行");
        // 放行资源
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行资源之后执行");
    }
}

