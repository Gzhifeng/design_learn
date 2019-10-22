package com.zhifeng.facade.service;


import com.zhifeng.common.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: IntegralService
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/5/2520:55
 */
@Service
public class IntegralService {

    private static final Logger logger = LoggerFactory.getLogger(IntegralService.class);

    public void addIntegral() {
        // 3.调用积分接口增加积分
        HttpClientUtils.doPost("jifen.com", "积分接口");
        logger.info(">>第三个模块:调用增加积分模块..");
    }
}
