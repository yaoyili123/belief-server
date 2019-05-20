package com.yaoyili.dao;

import com.yaoyili.model.SportClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SportClassMapper {

    int deleteByPrimaryKey(Integer scid);

    int insert(SportClass record);

    int insertSelective(SportClass record);

    SportClass selectByPrimaryKey(Integer scid);

    int updateByPrimaryKeySelective(SportClass record);

    int updateByPrimaryKey(SportClass record);
}