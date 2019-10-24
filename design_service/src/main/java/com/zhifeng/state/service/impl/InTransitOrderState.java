package com.zhifeng.state.service.impl;

import com.zhifeng.state.service.OrderState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ganzhifeng
 * @className InTransitOrderState
 * @date 2019/10/24 0024
 */
public class InTransitOrderState implements OrderState {

    private static final Logger logger = LoggerFactory.getLogger(InTransitOrderState.class);

    @Override
    public void orderService() {
        logger.info("切换为正在运送状态...");
    }
}
