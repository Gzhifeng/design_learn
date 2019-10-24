package com.zhifeng.state.service.impl;

import com.zhifeng.state.service.OrderState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ganzhifeng
 * @className ShippedAlreadyOrderState
 * @date 2019/10/24 0024
 */
public class ShippedAlreadyOrderState implements OrderState {

    private static final Logger logger = LoggerFactory.getLogger(ShippedAlreadyOrderState.class);

    @Override
    public void orderService() {
        logger.info("切换为已经发货状态...");
    }
}
