package com.zhifeng.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 收集日志
 * 具体装饰者
 *
 * @author ganzhifeng
 * @className LogDecorator
 * @date 2019/9/18 0018
 */
@Component
public class LogDecorator extends AbstractDecorator {

    private static final Logger logger = LoggerFactory.getLogger(LogDecorator.class);

    public LogDecorator() {
    }

    public LogDecorator(GatewayComponent gatewayComponent) {
        super(gatewayComponent);
    }

    @Override
    public void service() {

        //调用装饰类
        super.service();

        //日志收集
        logger.info("日志收集");
    }
}
