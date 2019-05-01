package com.yaoyili.service.impl;

import com.yaoyili.dao.UserCollectRecipeMapper;
import com.yaoyili.model.UserCollectRecipe;
import com.yaoyili.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private UserCollectRecipeMapper userCollectRecipeMapper;

    @Override
    public List<Integer> getRecipes(int uid) {
        return userCollectRecipeMapper.getRecipesByUser(uid);
    }

    @Override
    public void addRecipe(int uid, int rid) {
        userCollectRecipeMapper.insert(new UserCollectRecipe(uid, rid));
    }

    @Override
    public void deleteRecipe(int uid, int rid) {
        userCollectRecipeMapper.deleteByPrimaryKey(new UserCollectRecipe(uid, rid));
    }
}
