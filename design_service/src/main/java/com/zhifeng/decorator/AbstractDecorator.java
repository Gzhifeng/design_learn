package com.zhifeng.decorator;

/**
 * 定义抽象装饰者
 *
 * @author ganzhifeng
 * @className AbstractDecorator
 * @date 2019/9/18 0018
 */
public abstract class AbstractDecorator extends GatewayComponent{

    protected GatewayComponent gatewayComponent;

    public AbstractDecorator() {
    }

    public AbstractDecorator(GatewayComponent gatewayComponent) {
        this.gatewayComponent = gatewayComponent;
    }

    @Override
    public void service() {
        gatewayComponent.service();
    }

    public void setGatewayComponent(GatewayComponent gatewayComponent) {
        this.gatewayComponent = gatewayComponent;
    }
}
