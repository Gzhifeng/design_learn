package com.zhifeng.observer.simple;

/**
 * 抽象观察者
 *
 * @author ganzhifeng
 * @className ObServer
 * @date 2019/10/14 0014
 */
public interface ObServer {

    /**
     * 通知观察者更新信息
     *
     * @param message
     */
    void update(String message);

}
