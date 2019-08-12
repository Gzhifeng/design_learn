package com.zhifeng.chain;

import com.zhifeng.chain.mapper.PaymentChannelMapper;
import com.zhifeng.common.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 执行策略
 * @author ganzhifeng
 * @className PayContextStrategy
 * @date 2019/8/12 0012
 */
@Component
public class PayContextStrategy {

    @Autowired
    private SpringUtils springUtils;
    @Autowired(required = false)
    private PaymentChannelMapper paymentChannelMapper;

    public String toPay(String payCode) {
        String strategyBean = paymentChannelMapper.selectByChannelId(payCode);
        PayStrategy payStrategy = springUtils.getBean(strategyBean, PayStrategy.class);
        return payStrategy.toPay();
    }

}
