package com.zhifeng.ext.jdk.proxy.impl;

import com.zhifeng.ext.jdk.proxy.JavaClassLoader;
import com.zhifeng.ext.jdk.proxy.MyExtInvocationHandler;
import com.zhifeng.ext.jdk.proxy.MyProxy;
import com.zhifeng.proxy.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author ganzhifeng
 * @className MyExtInvocationHandlerImpl
 * @date 2019/10/11 0011
 */
public class MyExtInvocationHandlerImpl implements MyExtInvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExtInvocationHandlerImpl.class);

    /**
     * 目标执行对象 (被代理的对象)
     */
    private Object target;

    public MyExtInvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("纯手写JDK动态代理日志拦截开始");
        Object invoke = method.invoke(target, args);
        logger.info("纯手写JDK动态代理日志拦截结束");
        return invoke;
    }

    /**
     * 设置代理对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) MyProxy.newProxyInstance(new JavaClassLoader(), OrderService.class, this);
    }
}
