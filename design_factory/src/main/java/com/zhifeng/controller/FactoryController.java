package com.zhifeng.controller;

import com.zhifeng.common.result.Result;
import com.zhifeng.strategy.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzhifeng
 * @className FactoryController
 * @date 2019/9/16 0016
 */
@RestController
@RequestMapping("/api/v1")
public class FactoryController {

    @Autowired
    private PayContextStrategy payContextStrategy;

    /**
     * 工厂模式方法
     *
     * @author ganzhifeng
     * @param code
     *          ali_pay      模拟支付宝支付
     *          xiaomi_pay   模拟小米支付
     * @return
     */
    @GetMapping("/factory")
    public Result factory(String code) {

        //支付结果
        String res = payContextStrategy.toPay(code);

        Result result = new Result();
        result.setData(res);
        return result;
    }

}
