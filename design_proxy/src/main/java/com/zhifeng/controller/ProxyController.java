package com.zhifeng.controller;

import com.zhifeng.proxy.service.*;
import com.zhifeng.proxy.service.impl.OrderServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 代理模式控制类
 *
 * @author ganzhifeng
 * @className ProxyController
 * @date 2019/10/8 0008
 */
public class ProxyController {

    private static final Logger logger = LoggerFactory.getLogger(ProxyController.class);


    public static void main(String[] args) {

        /**
         * 静态代理
         * 基于接口实现
         */
        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderServiceProxy2Implements orderServiceProxy = new OrderServiceProxy2Implements();
        orderServiceProxy.setProxyOrderService(orderService);
        orderServiceProxy.order();

        logger.info("================分割线===============");

        //基于继承
        OrderServiceProxy2Extends orderServiceProxy2Extends = new OrderServiceProxy2Extends();
        orderServiceProxy2Extends.order();

        /**
         * 动态代理
         * jdk动态代理
         */
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(orderService);
        OrderService proxy = jdkInvocationHandler.getProxy();
        proxy.order();

        //cglib动态代理
        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();
        Enhancer enhancer = new Enhancer();

        //设置代理类的父类
        enhancer.setSuperclass(OrderServiceImpl.class);
        //设置回调对象
        enhancer.setCallback(cglibMethodInterceptor);
        //创建代理对象
        OrderServiceImpl o = (OrderServiceImpl) enhancer.create();
        o.order();
    }

}
