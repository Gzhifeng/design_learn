package com.zhifeng.chain;

/**
 * 支付接口
 * @className PayStrategy
 * @author ganzhifeng
 * @date 2019/8/9 0009
 */
public interface PayStrategy {

    /**
     * 支付算法骨架
     * @return
     */
     String toPay();

}
