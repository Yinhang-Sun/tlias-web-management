package com.jonathan.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc Request intercepted...Logic before releasing");
        //release
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Abc Request intercepted...Logic after releasing");
    }
}
