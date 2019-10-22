package com.zhifeng.facade.service;


import com.zhifeng.facade.PayFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PayCallbackService {

    @Autowired
    private PayFacade payFacade;

    // 采用 外观模式（门面） 包装模式  使用一个接口封装复杂的业务逻辑流程，让客户度使用起来更加简单！
////    public boolean callback(Map<String, String> verifySignature) {
//        // 1.第一步打印日志信息
//        String orderId = verifySignature.get("orderId"); // 获取后台通知的数据，其他字段也可用类似方式获取
//        String respCode = verifySignature.get("respCode");
//        log.info("orderId:{},respCode:{}", orderId, respCode);
//        // 2.修改订单状态为已经支付状态
//        new PaymentTransactionMapper() {
//            @Override
//            public void updatePaymentStatus() {
//                log.info(">>>修改订单状态为已经支付>>>>>");
//            }
//        }.updatePaymentStatus();
//        // 3.调用积分接口增加积分
//        HttpClientUtils.doPost("jifen.com", "积分接口");
//        // 4.调用消息服务平台提示
//        HttpClientUtils.doPost("msg.com", "调用消息接口");
//        return true;
////    }
    public boolean callback() {
        payFacade.facadecallback();
        return true;
    }

    private void baseCallback() {

    }
}


