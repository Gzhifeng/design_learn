package com.zhifeng.controller;

import com.zhifeng.chain.handler.GatewayHandlerFilter;
import com.zhifeng.chain.service.GatewayHandlerService;
import com.zhifeng.common.constants.CodeConstants;
import com.zhifeng.common.result.Result;
import com.zhifeng.chain.handler.factory.FactoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟网关调用
 * @author ganzhifeng
 * @className HandlerController
 * @date 2019/8/17 0017
 */
@RestController
@RequestMapping("/api/v1")
public class HandlerController {

    @Autowired
    private GatewayHandlerService gatewayHandlerService1;

    /**
     * 测试责任链模式,不涉及数据库
     * @return
     */
    @GetMapping("/gateway/factory")
    public Result gateway() {

        GatewayHandlerFilter gatewayHandler = FactoryHandler.getGatewayHandler();
        gatewayHandler.service();
        return new Result(CodeConstants.SUCCESS_CODE, CodeConstants.SUCCESS_MSG);
    }

    /**
     * 测试责任链模式
     * @return
     */
    @GetMapping("/gateway/handler")
    public Result gatewayHandler() {

        GatewayHandlerFilter gatewayHandler = gatewayHandlerService1.getGatewayHandler();
        gatewayHandler.service();
        return new Result(CodeConstants.SUCCESS_CODE, CodeConstants.SUCCESS_MSG);
    }
}
