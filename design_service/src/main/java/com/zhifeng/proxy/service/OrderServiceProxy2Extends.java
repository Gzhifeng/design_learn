package com.zhifeng.proxy.service;

import com.zhifeng.proxy.service.impl.OrderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理模式基于继承实现
 *
 * @author ganzhifeng
 * @className OrderServiceProxy2Extends
 * @date 2019/10/8 0008
 */
public class OrderServiceProxy2Extends extends OrderServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceProxy2Extends.class);

    @Override
    public void order() {

        logger.info("日志收集开始。。。");
        super.order();
        logger.info("日志收集结束。。。");
    }

}
