package com.zhifeng.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    public static String doPost(String url, String text) {
        logger.info(">>>Url:{},text:{}", url, text);
        return "success";
    }
}
