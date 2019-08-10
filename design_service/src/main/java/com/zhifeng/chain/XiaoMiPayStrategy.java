package com.zhifeng.chain;

import org.springframework.stereotype.Component;

/**
 * 模拟调用小米支付
 * @author ganzhifeng
 * @className XiaoMiPayStrategy
 * @date 2019/8/9 0009
 */
@Component
public class XiaoMiPayStrategy implements PayStrategy {

    @Override
    public String toPay() {
        String res = "调用小米支付接口";
        return res;
    }
}
