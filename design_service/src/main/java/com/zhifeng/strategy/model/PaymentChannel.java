package com.zhifeng.strategy.model;

import java.io.Serializable;

/**
 * 策略模式实体
 * @author ganzhifeng
 */
public class PaymentChannel implements Serializable {
    private Long id;

    private String channelName;

    private String channelId;

    private String strategyBeanId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getChannnelId() {
        return channelId;
    }

    public void setChannnelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getStrategyBeanId() {
        return strategyBeanId;
    }

    public void setStrategyBeanId(String strategyBeanId) {
        this.strategyBeanId = strategyBeanId == null ? null : strategyBeanId.trim();
    }
}