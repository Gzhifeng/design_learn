package com.zhifeng.chain.model;

import java.io.Serializable;

/**
 * 责任链模式使用
 * @author ganzhifeng
 */
public class GatewayHandler implements Serializable {
    private Integer id;

    private String handlerName;

    private String handlerId;

    private String prevHandlerId;

    private String nextHandlerId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName == null ? null : handlerName.trim();
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId == null ? null : handlerId.trim();
    }

    public String getPrevHandlerId() {
        return prevHandlerId;
    }

    public void setPrevHandlerId(String prevHandlerId) {
        this.prevHandlerId = prevHandlerId == null ? null : prevHandlerId.trim();
    }

    public String getNextHandlerId() {
        return nextHandlerId;
    }

    public void setNextHandlerId(String nextHandlerId) {
        this.nextHandlerId = nextHandlerId == null ? null : nextHandlerId.trim();
    }
}