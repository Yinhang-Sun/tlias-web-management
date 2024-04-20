package com.jonathan.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override//Initialization method, only called once
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initialization method executed!");
    }

    @Override//Called after intercepting the request, called multiple times
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo Request intercepted...Logic before releasing");
        //release
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Demo Request intercepted...Logic after releasing");
    }

    @Override//Destroy method, only called once
    public void destroy() {
        System.out.println("Destroying method executed!");
    }
}
