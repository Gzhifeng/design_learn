package com.zhifeng.strategy;

import org.springframework.stereotype.Component;

/**
 * 模拟调用支付宝支付
 * @className AliPayStrategy
 * @author ganzhifeng
 * @date 2019/8/9 0009
 */
@Component
public class AliPayStrategy implements PayStrategy{

    @Override
    public String toPay() {

        String res = "调用支付宝接口";
        return res;
    }
}
