package com.zhifeng.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟获取网关基本参数
 * 具体组件
 *
 * @author ganzhifeng
 * @className BasicComponentGateway
 * @date 2019/9/18 0018
 */
@Component
public class BasicComponentGateway extends GatewayComponent {

    private static final Logger logger = LoggerFactory.getLogger(BasicComponentGateway.class);

    @Override
    public void service() {
        logger.info("网关开始获取基本参数信息");
    }
}
