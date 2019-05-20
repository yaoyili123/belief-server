package com.yaoyili.dao;

import com.yaoyili.model.Recipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeMapper {

    List findByType(Integer tid);

    int deleteByPrimaryKey(Integer rid);

    int insert(Recipe record);

    int insertSelective(Recipe record);

    Recipe selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Recipe record);

    int updateByPrimaryKeyWithBLOBs(Recipe record);

    int updateByPrimaryKey(Recipe record);
}