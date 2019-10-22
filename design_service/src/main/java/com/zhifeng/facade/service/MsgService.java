package com.zhifeng.facade.service;

import com.zhifeng.common.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MsgService {

    private static final Logger logger = LoggerFactory.getLogger(MsgService.class);

    public void sendMsg() {
        // 3.调用积分接口增加积分
        HttpClientUtils.doPost("jifen.com", "积分接口");
        logger.info(">>第四个模块:调用消息服务平台模块..");
    }
}
