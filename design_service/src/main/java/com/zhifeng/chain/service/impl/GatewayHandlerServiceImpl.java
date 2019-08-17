package com.zhifeng.chain.service.impl;

import com.zhifeng.chain.handler.GatewayHandlerFilter;
import com.zhifeng.chain.mapper.GatewayHandlerMapper;
import com.zhifeng.chain.model.GatewayHandler;
import com.zhifeng.chain.service.GatewayHandlerService;
import com.zhifeng.common.util.SpringUtils;
import com.zhifeng.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ganzhifeng
 * @className GatewayHandlerServiceImpl
 * @date 2019/8/17 0017
 */
@Service("gatewayHandlerService1")
public class GatewayHandlerServiceImpl implements GatewayHandlerService {

    @Autowired(required = false)
    private GatewayHandlerMapper gatewayHandlerMapper;
    @Autowired
    private SpringUtils springUtils;

    /**
     * 避免多次请求数据库
     */
    private GatewayHandlerFilter gatewayHandlerFilter;

    @Override
    public GatewayHandlerFilter getGatewayHandler() {

        if (gatewayHandlerFilter != null) {
            return gatewayHandlerFilter;
        }

        //查询handler地址
        GatewayHandler gateway = gatewayHandlerMapper.selectFirstGateway();
        if (gateway == null) {
            return null;
        }

        //获取beanId
        String handlerId = gateway.getHandlerId();
        //获取第一个handler
        gatewayHandlerFilter = springUtils.getBean(handlerId, GatewayHandlerFilter.class);
        //获取下一个handlerId
        String nextHandlerId = gateway.getNextHandlerId();

        //组装handler责任链
        GatewayHandlerFilter tempHandlerFilter = gatewayHandlerFilter;
        while (StringUtil.notEmpty(nextHandlerId)) {

            //获取下一个handler
            GatewayHandlerFilter nextGatewayHandlerFilter = springUtils.getBean(nextHandlerId, GatewayHandlerFilter.class);
            tempHandlerFilter.setGatewayHandler(nextGatewayHandlerFilter);

            GatewayHandler tempHandler = gatewayHandlerMapper.selectByHandlerId(nextHandlerId);
            if (tempHandler == null) {
                break;
            }
            nextHandlerId = tempHandler.getNextHandlerId();
            tempHandlerFilter = nextGatewayHandlerFilter;
        }

        return this.gatewayHandlerFilter;
    }
}
