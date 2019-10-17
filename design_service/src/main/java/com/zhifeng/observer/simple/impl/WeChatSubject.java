package com.zhifeng.observer.simple.impl;

import com.zhifeng.observer.simple.AbstractSubject;
import com.zhifeng.observer.simple.ObServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模拟微信公众号发送通知
 *
 * @author ganzhifeng
 * @className WeChatSubject
 * @date 2019/10/17 0017
 */
public class WeChatSubject extends AbstractSubject {

    private static final Logger logger = LoggerFactory.getLogger(WeChatSubject.class);

    @Override
    public void notifyObServer(String message) {

        logger.info("开始设置微信群发消息：" + message);
        //调用观察者通知方案
        for (ObServer obServer : this.getObServerList()) {
            //调用该方法通知 获取具体的消息
            obServer.update(message);
        }

    }
}
