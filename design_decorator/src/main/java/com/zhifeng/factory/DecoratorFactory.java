package com.zhifeng.factory;

import com.zhifeng.common.util.SpringUtils;
import com.zhifeng.decorator.BasicComponentGateway;
import com.zhifeng.decorator.GatewayComponent;
import com.zhifeng.decorator.LimitDecorator;
import com.zhifeng.decorator.LogDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取装饰对象
 *
 * @author ganzhifeng
 * @className DecoratorFactory
 * @date 2019/9/18 0018
 */
@Component
public class DecoratorFactory {

    @Autowired
    private SpringUtils springUtils;

    public GatewayComponent gatewayComponent() {

        LogDecorator logDecorator = (LogDecorator) springUtils.getBean("logDecorator");
        LimitDecorator limitDecorator = (LimitDecorator) springUtils.getBean("limitDecorator");

        BasicComponentGateway basicComponentGateway = new BasicComponentGateway();


        limitDecorator.setGatewayComponent(logDecorator);
        logDecorator.setGatewayComponent(basicComponentGateway);
        return limitDecorator;
    }

}
