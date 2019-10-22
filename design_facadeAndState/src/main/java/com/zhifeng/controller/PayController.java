package com.zhifeng.controller;

import com.zhifeng.facade.service.PayCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外观模式
 */
@RestController
@RequestMapping("/api/v1")
public class PayController {

    @Autowired
    private PayCallbackService payCallbackService;

    @RequestMapping("/payCallback")
    public String payCallback() {
        payCallbackService.callback();
        return "success";
    }
}
