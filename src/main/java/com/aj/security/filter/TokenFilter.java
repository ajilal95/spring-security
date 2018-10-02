/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aj.security.filter;

import com.aj.consts.Security;
import com.aj.security.token.AuthToken;
import java.io.IOException;
import java.util.Collection;
import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author ajilal
 */
public class TokenFilter extends GenericFilterBean{

    @Override
    public void doFilter(ServletRequest request, 
            ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpReq = (HttpServletRequest) request;
        
        String token = httpReq.getHeader(Security.TOKEN_HEAD);
        if(token != null){
            
            SecurityContextHolder.getContext().setAuthentication(new AuthToken(token));
            
        }
        chain.doFilter(request, response);
    }
    
}
