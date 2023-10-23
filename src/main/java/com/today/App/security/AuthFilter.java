package com.today.App.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@WebFilter(urlPatterns = {"/**"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
         log.info("--- filter init ---");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
         log.info("--- doFilter ---");
        // 对 request,response 进行预处理
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
         log.info("--- filter destroy ---");
    }
}

