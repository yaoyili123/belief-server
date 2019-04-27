package com.yaoyili.dao;

import com.yaoyili.model.UserCollectRecipe;

public interface UserCollectRecipeMapper {
    int deleteByPrimaryKey(UserCollectRecipe key);

    int insert(UserCollectRecipe record);

    int insertSelective(UserCollectRecipe record);
}