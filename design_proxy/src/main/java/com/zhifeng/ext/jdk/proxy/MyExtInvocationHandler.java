package com.zhifeng.ext.jdk.proxy;

import java.lang.reflect.Method;

/**
 * 模拟 jdk动态模拟 InvocationHandler接口
 *
 * @author ganzhifeng
 * @className MyExtInvocationHandler
 * @date 2019/10/11 0011
 */
public interface MyExtInvocationHandler {

    /**
     * 模拟 jdk动态模拟 InvocationHandler接口
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
