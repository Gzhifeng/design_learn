package com.zhifeng.chain.handler.impl;

import com.zhifeng.chain.handler.GatewayHandlerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟用户会话拦截
 * @author ganzhifeng
 * @className ConversationHandler
 * @date 2019/8/17 0017
 */
@Component
public class ConversationHandler extends GatewayHandlerFilter {

    private static Logger logger = LoggerFactory.getLogger(ConversationHandler.class);

    @Override
    public void service() {
        logger.info("模拟用户会话拦截");
        next();
    }
}
