package com.epam.star.filter;

import javax.servlet.*;
import java.io.IOException;

public class Encoding implements Filter {
    String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        encoding = filterConfig.getInitParameter("requestEncoding");
//        if (encoding == null)
//            encoding = "UTF-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.setCharacterEncoding(encoding);
//        servletResponse.setCharacterEncoding(encoding);
//        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
