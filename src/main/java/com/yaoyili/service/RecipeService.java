package com.yaoyili.service;

import com.yaoyili.model.UserCollectRecipe;

import java.util.List;

public interface RecipeService {

    List<Integer> getRecipes(int uid);

    void addRecipe(int uid, int rid);

    void deleteRecipe(int uid, int rid);
}
