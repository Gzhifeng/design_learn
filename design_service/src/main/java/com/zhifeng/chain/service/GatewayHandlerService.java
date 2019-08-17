package com.zhifeng.chain.service;

import com.zhifeng.chain.handler.GatewayHandlerFilter;

/**
 * @author ganzhifeng
 * @className GatewayHandlerService
 * @date 2019/8/17 0017
 */
public interface GatewayHandlerService {

    /**
     * 获取网关责任链
     * @return
     */
    GatewayHandlerFilter getGatewayHandler();
}
