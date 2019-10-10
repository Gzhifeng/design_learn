package com.zhifeng.proxy.service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.reflect.Method;

/**
 * cglib动态代理
 *
 * @author ganzhifeng
 * @className CglibMethodInterceptor
 * @date 2019/10/10 0010
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CglibMethodInterceptor.class);

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        logger.info("cglib日志开始收集。。。");
        Object o1 = methodProxy.invokeSuper(o, objects);
        logger.info("cglib日志收集结束。。。");
        return o1;
    }
}
