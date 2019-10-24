package com.zhifeng.state;

import com.zhifeng.state.service.OrderState;

/**
 * @author ganzhifeng
 * @className ContextState
 * @date 2019/10/24 0024
 */
public class ContextState {

    private OrderState orderState;

    public ContextState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void switchStateOrder() {
        orderState.orderService();
    }

}
