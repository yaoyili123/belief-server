package com.yaoyili.dao;

import com.yaoyili.model.UserJoinClass;

public interface UserJoinClassMapper {
    int deleteByPrimaryKey(UserJoinClass key);

    int insert(UserJoinClass record);

    int insertSelective(UserJoinClass record);
}