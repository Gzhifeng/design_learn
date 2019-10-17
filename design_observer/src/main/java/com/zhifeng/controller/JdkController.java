package com.zhifeng.controller;


import com.zhifeng.observer.jdk.MessageObServable;
import com.zhifeng.observer.jdk.impl.EmailObServer;
import com.zhifeng.observer.jdk.impl.SmsObServer;
import net.sf.json.JSONObject;

/**
 * @author ganzhifeng
 * @className JdkController
 * @date 2019/10/17 0017
 */
public class JdkController {

    public static void main(String[] args) {
        //创建具体的主题
        MessageObServable messageObServable = new MessageObServable();
        //注册观察者
        messageObServable.addObserver(new EmailObServer());
        messageObServable.addObserver(new SmsObServer());
        //群发消息
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("乔巴", "悬赏金额15贝利");
        jsonObject.put("索隆", "悬赏金额80000000贝利");
        jsonObject.put("路飞", "悬赏金额100000000贝利");

        messageObServable.notifyObservers(jsonObject);
    }

}
