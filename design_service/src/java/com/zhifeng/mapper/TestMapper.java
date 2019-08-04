package com.zhifeng.mapper;

import com.zhifeng.model.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);
}