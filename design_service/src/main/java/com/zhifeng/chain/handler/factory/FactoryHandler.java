package com.zhifeng.chain.handler.factory;

import com.zhifeng.chain.handler.GatewayHandlerFilter;
import com.zhifeng.chain.handler.impl.BlacklistHandler;
import com.zhifeng.chain.handler.impl.ConversationHandler;
import com.zhifeng.chain.handler.impl.CurrentLimitHandler;

/**
 * 使用工厂模式封装handler责任链
 * @author ganzhifeng
 * @className FactoryHandler
 * @date 2019/8/17 0017
 */
public class FactoryHandler {

    /**
     * 组装责任链
     * @return
     */
    public static GatewayHandlerFilter getGatewayHandler() {

        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        BlacklistHandler blacklistHandler = new BlacklistHandler();
        ConversationHandler conversationHandler = new ConversationHandler();

        currentLimitHandler.setGatewayHandler(blacklistHandler);
        blacklistHandler.setGatewayHandler(conversationHandler);

        return currentLimitHandler;
    }

}
