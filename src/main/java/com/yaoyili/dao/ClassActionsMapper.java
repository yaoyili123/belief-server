package com.yaoyili.dao;

import com.yaoyili.model.ClassActionsKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassActionsMapper {
    int deleteByPrimaryKey(ClassActionsKey key);

    int insert(ClassActionsKey record);

    int insertSelective(ClassActionsKey record);
}