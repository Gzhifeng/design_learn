package com.zhifeng.reconsitution.code;


import com.zhifeng.common.util.HttpClientUtils;
import com.zhifeng.facade.mapper.PaymentTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 模拟代码，展示未重构前的代码布局
 *
 * 用户下单成功后，有那些操作？
 * 1.增加支付回调接口日志
 * 2.修改订单数据库状态为已经成功
 * 3.调用积分服务接口
 * 4.调用消息服务平台服务接口
 */
public class PayCallbackService {

    private static final Logger logger = LoggerFactory.getLogger(PayCallbackService.class);

    public boolean callback(Map<String, String> verifySignature) {
        // 1.第一步打印日志信息
        // 获取后台通知的数据，其他字段也可用类似方式获取
        String orderId = verifySignature.get("orderId");
        String respCode = verifySignature.get("respCode");
        logger.info("orderId:{},respCode:{}", orderId, respCode);
        // 2.修改订单状态为已经支付
        new PaymentTransactionMapper() {
            @Override
            public void updatePaymentStatus() {
                logger.info(">>>修改订单状态为已经支付>>>>>");
            }
        }.updatePaymentStatus();
        // 3.调用积分接口增加积分
        HttpClientUtils.doPost("jifen.com", "积分接口");
        // 4.调用消息服务平台提示
        HttpClientUtils.doPost("msg.com", "调用消息接口");
        return true;
    }
}
