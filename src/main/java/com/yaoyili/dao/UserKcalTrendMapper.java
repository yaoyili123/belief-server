package com.yaoyili.dao;

import com.yaoyili.model.UserKcalTrend;

public interface UserKcalTrendMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserKcalTrend record);

    int insertSelective(UserKcalTrend record);

    UserKcalTrend selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserKcalTrend record);

    int updateByPrimaryKey(UserKcalTrend record);
}