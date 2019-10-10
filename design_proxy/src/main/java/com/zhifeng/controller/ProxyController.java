package com.zhifeng.controller;

import com.zhifeng.proxy.service.JdkInvocationHandler;
import com.zhifeng.proxy.service.OrderService;
import com.zhifeng.proxy.service.OrderServiceProxy2Extends;
import com.zhifeng.proxy.service.OrderServiceProxy2Implements;
import com.zhifeng.proxy.service.impl.OrderServiceImpl;
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
         */
        //基于接口实现
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
         */
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(orderService);
        OrderService proxy = jdkInvocationHandler.getProxy();
        proxy.order();
    }

}
