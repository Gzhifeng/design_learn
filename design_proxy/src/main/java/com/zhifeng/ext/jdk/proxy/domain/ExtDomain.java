package com.zhifeng.ext.jdk.proxy.domain;

import com.zhifeng.ext.jdk.proxy.impl.MyExtInvocationHandlerImpl;
import com.zhifeng.proxy.service.OrderService;
import com.zhifeng.proxy.service.impl.OrderServiceImpl;

/**
 * @author ganzhifeng
 * @className ExtDomain
 * @date 2019/10/11 0011
 */
public class ExtDomain {

    public static void main(String[] args) throws Throwable {

        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderService proxy = new MyExtInvocationHandlerImpl(orderService).getProxy();
        proxy.order();

    }

}
