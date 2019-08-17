package com.zhifeng.chain.handler.impl;

import com.zhifeng.chain.handler.GatewayHandlerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟黑名单拦截
 * @author ganzhifeng
 * @className GatewayHandlerFilter
 * @date 2019/8/17 0017
 */
@Component
public class BlacklistHandler extends GatewayHandlerFilter {

    private static Logger logger = LoggerFactory.getLogger(BlacklistHandler.class);

    @Override
    public void service() {
        logger.info("模拟黑名单拦截");
        next();
    }
}
