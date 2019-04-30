package com.yaoyili.dao;

import com.yaoyili.model.UserJoinClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserJoinClassMapper {

    List<Integer> getClassesbyUser(@Param("uid") Integer uid);

    int deleteByPrimaryKey(UserJoinClass key);

    int insert(UserJoinClass record);

    int insertSelective(UserJoinClass record);
}