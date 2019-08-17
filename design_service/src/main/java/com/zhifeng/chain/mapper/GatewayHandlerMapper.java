package com.zhifeng.chain.mapper;

import com.zhifeng.chain.model.GatewayHandler;

/**
 * @author ganzhifeng
 */
public interface GatewayHandlerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GatewayHandler record);

    int insertSelective(GatewayHandler record);

    GatewayHandler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatewayHandler record);

    int updateByPrimaryKey(GatewayHandler record);

    /**
     * 查询第一个网关拦截handler
     * @return
     */
    GatewayHandler selectFirstGateway();

    /**
     * 根据handlerId获取handler对象
     * @param nextHandlerId
     * @return
     */
    GatewayHandler selectByHandlerId(String nextHandlerId);
}