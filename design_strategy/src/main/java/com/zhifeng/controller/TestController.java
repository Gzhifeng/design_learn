package com.zhifeng.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仅用来测试项目启动
 * @className TestController
 * @author ganzhifeng
 * @date 2019/7/27 0027
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String testRun() {
        return "running...";
    }

}
