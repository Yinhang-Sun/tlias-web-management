package com.jonathan.filter;

import com.alibaba.fastjson.JSONObject;
import com.jonathan.pojo.Result;
import com.jonathan.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //1. get request url
        String url = req.getRequestURL().toString();
        log.info("Requested url: {}",url);

        //2.Determine whether the request URL contains login.
        // If it does, it means that it is a login operation and is allowed.
        if(url.contains("login")){
            log.info("Login operation, release...");
            chain.doFilter(request,response);
            return;
        }

        //3.Get the token in the request header.
        String jwt = req.getHeader("token");

        //4.Determine whether the token exists.
        // If it does not exist, return an error result (not logged in).
        if(!StringUtils.hasLength(jwt)){
            log.info("The request header token is empty and non-login information is returned.");
            Result error = Result.error("NOT_LOGIN");
            //Manual conversion object --json --------> Alibaba fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //5.Parse the token. If the parsing fails, an error result will be returned (not logged in).
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt parsing failed
            e.printStackTrace();
            log.info("Failed to parse the token and returned a not logged in error message");
            Result error = Result.error("NOT_LOGIN");
            //Manual conversion object --json --------> Alibaba fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //6.Release
        log.info("The token is legal and released");
        chain.doFilter(request, response);

    }
}
