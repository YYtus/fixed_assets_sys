package com.thundersoft.fixed_assets_sys.filter;

import com.thundersoft.fixed_assets_sys.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class AuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/login")){
            filterChain.doFilter(request,response);
            return;
        }
        if (request.getMethod().equalsIgnoreCase("options")){
            filterChain.doFilter(request,response);
            return;
        }
        String token = request.getHeader("token");
        if (token==null){
            throw new RuntimeException("凭证不可为空");
        }
        Claims claims = JwtUtil.parse(token);
        if (claims.getExpiration().before(new Date())){
            throw new RuntimeException("凭证已过期！");
        }
//        上下文配置
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        claims.getSubject(),
                        null,
                        Collections.emptyList()
                )
        );
        filterChain.doFilter(request,response);
    }
}
