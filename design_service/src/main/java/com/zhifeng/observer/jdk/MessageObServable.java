package com.zhifeng.observer.jdk;


import java.util.Observable;

/**
 * 自定义jdk主题
 *
 * @author ganzhifeng
 * @className MessageObServable
 * @date 2019/10/17 0017
 */
public class MessageObServable extends Observable {

    @Override
    public void notifyObservers(Object arg) {

        //修改状态为可以群发，jdk默认不能群发消息
        setChanged();
        //发送消息
        super.notifyObservers(arg);
    }
}
