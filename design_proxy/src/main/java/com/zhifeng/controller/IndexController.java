package com.zhifeng.controller;

import com.zhifeng.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzhifeng
 * @className IndexController
 * @date 2019/10/11 0011
 */
@RestController
@RequestMapping("/api/v1")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/getUser")
    public Result getUser(String username) {
        logger.info("username: " + username);
        Result result = new Result();
        result.setData(username);
        return result;
    }

}
