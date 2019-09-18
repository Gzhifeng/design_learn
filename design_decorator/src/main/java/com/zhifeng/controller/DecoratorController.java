package com.zhifeng.controller;

import com.zhifeng.common.result.Result;
import com.zhifeng.decorator.GatewayComponent;
import com.zhifeng.factory.DecoratorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzhifeng
 * @className DecoratorController
 * @date 2019/09/18 0018
 */
@RestController
@RequestMapping("/api/v1")
public class DecoratorController {

    @Autowired
    private DecoratorFactory decoratorFactory;

    private static final Logger logger = LoggerFactory.getLogger(DecoratorController.class);

    /**
     * 装饰者模式测试
     *
     * @author ganzhifeng
     * @data 2019/09/18
     * @return
     */
    @GetMapping("/decorator")
    public Result decorator() {

        logger.info("装饰者模式测试");

        GatewayComponent gatewayComponent = decoratorFactory.gatewayComponent();
        gatewayComponent.service();

        Result result = new Result();
        return result;
    }

}
