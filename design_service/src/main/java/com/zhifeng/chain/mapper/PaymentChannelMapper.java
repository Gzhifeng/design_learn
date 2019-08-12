package com.zhifeng.chain.mapper;

import com.zhifeng.chain.model.PaymentChannel;

/**
 * 执行策略
 * @author ganzhifeng
 */
public interface PaymentChannelMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PaymentChannel record);

    int insertSelective(PaymentChannel record);

    PaymentChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentChannel record);

    int updateByPrimaryKey(PaymentChannel record);

    /**
     * 获取执行策略
     * @param payCode
     * @return
     */
    String selectByChannelId(String payCode);
}