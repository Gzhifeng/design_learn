package com.zhifeng.observer.jdk.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ganzhifeng
 * @className EmailObServer
 * @date 2019/10/17 0017
 */
public class SmsObServer implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(SmsObServer.class);

    @Override
    public void update(Observable o, Object arg) {
        logger.info("悬赏单更新：" + arg);
    }
}
