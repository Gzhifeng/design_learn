package com.zhifeng.controller;

import com.zhifeng.observer.simple.AbstractSubject;
import com.zhifeng.observer.simple.impl.UserObServer;
import com.zhifeng.observer.simple.impl.WeChatSubject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzhifeng
 * @className SimpleController
 * @date 2019/10/17 0017
 */
@RestController
@RequestMapping("/api/v1")
public class SimpleController {

    @GetMapping("/simple")
    public void simple() {
        //1.注册主题
        AbstractSubject weChatSubject = new WeChatSubject();
        //2.添加观察者 订阅主题
        weChatSubject.addObServer(new UserObServer("小嗝嗝"));
        weChatSubject.addObServer(new UserObServer("我大索隆"));
        //3.设置发送消息
        weChatSubject.notifyObServer("此界乘三,无我不断者,三刀流奥义,一大‧三千‧大千世界");
    }

}
