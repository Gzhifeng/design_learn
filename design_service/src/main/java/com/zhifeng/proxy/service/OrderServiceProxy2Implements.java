package com.zhifeng.proxy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理模式基于接口实现
 *
 * @author ganzhifeng
 * @className OrderServiceProxy2Implements
 * @date 2019/10/8 0008
 */
public class OrderServiceProxy2Implements implements OrderService {

    /**
     * 代理对象
     */
    private OrderService proxyOrderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceProxy2Implements.class);

    public OrderService getProxyOrderService() {
        return proxyOrderService;
    }

    public void setProxyOrderService(OrderService proxyOrderService) {
        this.proxyOrderService = proxyOrderService;
    }

    @Override
    public void order() {

        logger.info("日志收集开始。。。");
        proxyOrderService.order();
        logger.info("日志收集结束。。。");
    }
}
