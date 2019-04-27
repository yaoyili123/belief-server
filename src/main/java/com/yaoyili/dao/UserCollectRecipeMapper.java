package com.yaoyili.dao;

import com.yaoyili.model.UserCollectRecipe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCollectRecipeMapper {
    int deleteByPrimaryKey(UserCollectRecipe key);

    int insert(UserCollectRecipe record);

    int insertSelective(UserCollectRecipe record);
}