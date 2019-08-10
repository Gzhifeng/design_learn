package com.zhifeng.chain.mapper;

import com.zhifeng.chain.model.PaymentChannel;

public interface PaymentChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaymentChannel record);

    int insertSelective(PaymentChannel record);

    PaymentChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentChannel record);

    int updateByPrimaryKey(PaymentChannel record);
}