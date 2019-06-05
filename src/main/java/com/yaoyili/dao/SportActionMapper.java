package com.yaoyili.dao;

import com.yaoyili.model.SportAction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportActionMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(SportAction record);

    int insertSelective(SportAction record);

    SportAction selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(SportAction record);

    int updateByPrimaryKey(SportAction record);

    List<SportAction> getActionsByScid(Integer scid);
}