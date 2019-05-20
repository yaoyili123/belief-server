package com.yaoyili.dao;

import com.yaoyili.model.RecipeType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeTypeMapper {

    List getAll();

    int deleteByPrimaryKey(Integer tid);

    int insert(RecipeType record);

    int insertSelective(RecipeType record);

    RecipeType selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(RecipeType record);

    int updateByPrimaryKey(RecipeType record);
}