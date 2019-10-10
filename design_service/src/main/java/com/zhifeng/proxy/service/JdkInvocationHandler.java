package com.zhifeng.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *
 * @author ganzhifeng
 * @className JdkInvocationHandler
 * @date 2019/10/10 0010
 */
public class JdkInvocationHandler implements InvocationHandler {

    /**
     * 目标对象
     */
    public Object tagert;

    private static final Logger logger = LoggerFactory.getLogger(JdkInvocationHandler.class);

    public JdkInvocationHandler(Object tagert) {
        this.tagert = tagert;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("日志开始收集。。。");
        Object invoke = method.invoke(tagert, args);
        logger.info("日志收集结束。。。");
        return invoke;
    }

    /**
     * 获取代理对象接口
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(tagert.getClass().getClassLoader(), tagert.getClass().getInterfaces(), this);
    }

}
