package com.zhifeng.chain.handler;

/**
 * 模拟网关，定义共同抽象行为
 * @author ganzhifeng
 * @className GatewayHandlerFilter
 * @date 2019/8/17 0017
 */
public abstract class GatewayHandlerFilter {

    /**
     * 执行下一个handler
     */
    protected GatewayHandlerFilter gatewayHandler;

    /**
     * 处理业务逻辑
     */
    public abstract void service();

    public void setGatewayHandler(GatewayHandlerFilter gatewayHandler) {
        this.gatewayHandler = gatewayHandler;
    }

    /**
     * 执行下一步
     */
    protected void next() {
        if (gatewayHandler != null) {
            gatewayHandler.service();
        }
    }
}
