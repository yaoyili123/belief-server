package com.yaoyili.service;

import com.yaoyili.model.Food;
import com.yaoyili.model.Recipe;
import com.yaoyili.model.RecipeType;
import com.yaoyili.model.UserCollectRecipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getRecipesByType(int tid);

    List<RecipeType> getRecipeType();

    List<Food> getFoods();

    List<Recipe> getRecipesByUser(int uid);

    void addRecipe(int uid, int rid);

    void deleteRecipe(int uid, int rid);
}
