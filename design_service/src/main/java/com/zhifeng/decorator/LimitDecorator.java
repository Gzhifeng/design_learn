package com.zhifeng.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * API限流
 * 具体装饰者
 *
 * @author ganzhifeng
 * @className LimitDecorator
 * @date 2019/9/18 0018
 */
@Component
public class LimitDecorator extends AbstractDecorator {

    private static final Logger logger = LoggerFactory.getLogger(LimitDecorator.class);

    public LimitDecorator() {
    }

    public LimitDecorator(GatewayComponent gatewayComponent) {
        super(gatewayComponent);
    }

    @Override
    public void service() {

        //调用装饰类
        super.service();

        //API接口限流
        logger.info("API接口限流");
    }
}
