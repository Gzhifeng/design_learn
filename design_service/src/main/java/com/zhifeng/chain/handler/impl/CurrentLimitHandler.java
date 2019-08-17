package com.zhifeng.chain.handler.impl;

import com.zhifeng.chain.handler.GatewayHandlerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟网关限流
 * @author ganzhifeng
 * @className CurrentLimitHandler
 * @date 2019/8/17 0017
 */
@Component
public class CurrentLimitHandler extends GatewayHandlerFilter {

    private static Logger logger = LoggerFactory.getLogger(CurrentLimitHandler.class);

    @Override
    public void service() {
        logger.info("接口限流");
        next();
    }
}
