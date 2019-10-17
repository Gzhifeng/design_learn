package com.zhifeng.observer.simple.impl;

import com.zhifeng.observer.simple.ObServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ganzhifeng
 * @className UserObServer
 * @date 2019/10/17 0017
 */
public class UserObServer implements ObServer {

    private static final Logger logger = LoggerFactory.getLogger(UserObServer.class);

    /**
     * 订阅者用户名称
     */
    private String username;

    public UserObServer(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        logger.info(username + ",老师收到微信服务通知的消息:" + message);
    }
}
