package com.yaoyili.dao;

import com.yaoyili.model.UserAuth;

public interface UserAuthMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);
}