package com.yaoyili.service;

import com.yaoyili.controller.RecipeAtCollect;
import com.yaoyili.model.*;

import java.util.List;

public interface RecipeService {

    List<RecipeAtCollect> getRecipesByType(int tid, int uid);

    List<RecipeType> getRecipeType();

    List<Food> getFoods();

    List<Food> getFoodsByType(int tid);

    Food getFoodDetail(int fid);

    List<Recipe> getRecipesByUser(int uid);

    void addRecipe(int uid, int rid);

    void deleteRecipe(int uid, int rid);

    RecipeDetail getRecipeDetail(int rid);
}
