package com.yaoyili.dao;

import com.yaoyili.model.UserCollectRecipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCollectRecipeMapper {

    List<Integer> getRecipesByUser(Integer uid);

    int deleteByPrimaryKey(UserCollectRecipe key);

    int insert(UserCollectRecipe record);

    int insertSelective(UserCollectRecipe record);
}