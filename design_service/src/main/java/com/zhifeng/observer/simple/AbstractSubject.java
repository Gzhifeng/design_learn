package com.zhifeng.observer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题
 *
 * @author ganzhifeng
 * @className AbstractSubject
 * @date 2019/10/14 0014
 */
public abstract class AbstractSubject {

    /**
     * 观察者集合
     */
    private List<ObServer> obServerList;

    public List<ObServer> getObServerList() {
        return obServerList;
    }

    /**
     * 添加观察者（注册观察者）
     *
     * @param obServer
     */
    public void addObServer(ObServer obServer) {
        if (obServerList == null) {
            obServerList = new ArrayList<>();
        }
        obServerList.add(obServer);
    }

    /**
     * 移除观察者
     *
     * @param obServer
     */
    public void removeObServer(ObServer obServer) {
        if (obServerList == null) {
            return;
        }
        obServerList.remove(obServer);
    }

    /**
     * 通知消息
     *
     * @param message
     */
    public abstract void notifyObServer(String message);
}
