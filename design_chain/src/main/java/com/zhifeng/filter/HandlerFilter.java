package com.zhifeng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查看拦截，对责任链学习代码没有实际意义
 * @author ganzhifeng
 * @className HandlerFilter
 * @date 2019/8/17 0017
 */
public class HandlerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 放行执行下一个请求
        chain.doFilter(req,res);
    }

    @Override
    public void destroy() {

    }
}
