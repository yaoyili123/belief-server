package com.yaoyili.dao;

import com.yaoyili.model.UserKcalTrend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserKcalTrendMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserKcalTrend record);

    int insertSelective(UserKcalTrend record);

    List<UserKcalTrend> selectbyUser(Integer uid);

    UserKcalTrend selectbyKeys(UserKcalTrend record);

    int updateByPrimaryKeySelective(UserKcalTrend record);

    int updateByPrimaryKey(UserKcalTrend record);
}