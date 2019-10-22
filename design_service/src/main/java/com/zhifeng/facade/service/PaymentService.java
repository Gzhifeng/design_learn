package com.zhifeng.facade.service;


import com.zhifeng.facade.mapper.PaymentTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: PaymentService
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/2520:53
 */
@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public void updatePaymentStatus() {
        new PaymentTransactionMapper() {
            @Override
            public void updatePaymentStatus() {
                logger.info(">>>第二个模块:修改订单状态为已经支付>>>>>");
            }
        }.updatePaymentStatus();
    }


}
