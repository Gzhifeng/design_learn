package com.zhifeng.controller;

import com.zhifeng.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟支付调用
 * @author ganzhifeng
 * @className PayController
 * @date 2019/8/9 0009
 */
@RestController
public class PayController {

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @GetMapping("/pay")
    public Result pay(String payCode) {

        logger.info("支付货币");
        Result result = new Result();



        return result;
    }

}
