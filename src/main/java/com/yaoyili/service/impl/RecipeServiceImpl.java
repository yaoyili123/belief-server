package com.yaoyili.service.impl;

import com.yaoyili.dao.FoodMapper;
import com.yaoyili.dao.RecipeMapper;
import com.yaoyili.dao.RecipeTypeMapper;
import com.yaoyili.dao.UserCollectRecipeMapper;
import com.yaoyili.model.Food;
import com.yaoyili.model.Recipe;
import com.yaoyili.model.RecipeType;
import com.yaoyili.model.UserCollectRecipe;
import com.yaoyili.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private UserCollectRecipeMapper userCollectRecipeMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private RecipeTypeMapper recipeTypeMapper;

   @Override
    public List<Recipe> getRecipesByType(int tid) {
        return recipeMapper.findByType(tid);
    }

    @Override
    public List<RecipeType> getRecipeType() {

        return recipeTypeMapper.getAll();
    }

    @Override
    public List<Food> getFoods() {
        return foodMapper.getAll();
    }

    @Override
    public List<Recipe> getRecipesByUser(int uid) {
        List<Integer> recipeList =  userCollectRecipeMapper.getRecipesByUser(uid);

        List<Recipe> res = new ArrayList<Recipe>();
        for (Integer rid: recipeList) {
            res.add(recipeMapper.selectByPrimaryKey(rid));
        }
        return res;
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
