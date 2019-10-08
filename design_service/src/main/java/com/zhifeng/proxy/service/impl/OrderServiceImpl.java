package com.zhifeng.proxy.service.impl;

import com.zhifeng.proxy.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ganzhifeng
 * @className OrderServiceImpl
 * @date 2019/9/29 0029
 */
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public void order() {
        logger.info("用户下单操作。。。");
    }
}
