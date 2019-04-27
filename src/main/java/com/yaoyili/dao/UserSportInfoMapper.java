package com.yaoyili.dao;

import com.yaoyili.model.UserSportInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSportInfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserSportInfo record);

    int insertSelective(UserSportInfo record);

    UserSportInfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserSportInfo record);

    int updateByPrimaryKey(UserSportInfo record);
}