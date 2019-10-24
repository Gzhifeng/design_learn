package com.zhifeng.domain;

import com.zhifeng.state.ContextState;
import com.zhifeng.state.service.impl.AlreadySignedOrderState;

/**
 * @author ganzhifeng
 * @className StateDomian
 * @date 2019/10/24 0024
 */
public class StateDomian {

    public static void main(String[] args) {
        ContextState contextState = new ContextState(new AlreadySignedOrderState());
        contextState.switchStateOrder();
    }

}
