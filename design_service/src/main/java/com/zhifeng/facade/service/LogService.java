package com.zhifeng.facade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    public void logService() {
        logger.info("第一个模块:日志的收集与打印...");
    }
}
