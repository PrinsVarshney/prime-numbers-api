package com.company.primenumbers.rest.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	log.debug("CROSFilter init.");
    	// Requirements not clarified.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*"); //NOSONAR
        response.setHeader("Access-Control-Allow-Methods", "GET"); //NOSONAR
        response.setHeader("Access-Control-Max-Age", "3600"); //NOSONAR
        response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept"); //NOSONAR
        response.setHeader("Access-Control-Expose-Headers", "Location"); //NOSONAR
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    	log.debug("CROSFilter destroy.");
    	// Requirements not clarified.
    }

}
