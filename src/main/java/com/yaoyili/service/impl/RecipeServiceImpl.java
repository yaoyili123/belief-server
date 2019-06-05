package com.yaoyili.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yaoyili.controller.RecipeAtCollect;
import com.yaoyili.dao.FoodMapper;
import com.yaoyili.dao.RecipeMapper;
import com.yaoyili.dao.RecipeTypeMapper;
import com.yaoyili.dao.UserCollectRecipeMapper;
import com.yaoyili.model.*;
import com.yaoyili.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Gson gson = new Gson();

   @Override
    public List<RecipeAtCollect> getRecipesByType(int tid, int uid) {

       List<Recipe> recipeList = recipeMapper.findByType(tid);
       List<RecipeAtCollect> recipeAtCollects = new ArrayList<>();
       if (uid == 0) {
            recipeList.forEach(item -> {
                RecipeAtCollect recipeAtCollect = new RecipeAtCollect(item);
                recipeAtCollect.setCollected(false);
                recipeAtCollects.add(recipeAtCollect);
            });
            return recipeAtCollects;
       }
       List<Integer> collectRecipe = userCollectRecipeMapper.getRecipesByUser(uid);
       int idx = 0;
       int size = collectRecipe.size();
       for (int i = 0; i < size; i++) {
           Recipe recipe = recipeList.get(idx);

           int a = collectRecipe.get(i), b = recipe.getRid();
           if (a == b) {
               RecipeAtCollect recipeAtCollect = new RecipeAtCollect(recipe);
               recipeAtCollect.setCollected(true);
               recipeAtCollects.add(recipeAtCollect);
               idx++;
           }
           if (idx == recipeList.size())
               break;
       }
       for (int i = idx; idx < recipeList.size(); i++) {
           Recipe recipe = recipeList.get(i);
           RecipeAtCollect recipeAtCollect = new RecipeAtCollect(recipe);
           recipeAtCollect.setCollected(false);
           recipeAtCollects.add(recipeAtCollect);
       }

       return recipeAtCollects;
    }

    @Override
    public List<RecipeType> getRecipeType() {

        return recipeTypeMapper.getAll();
    }

    @Override
    public RecipeDetail getRecipeDetail(int rid) {
        Recipe recipe = recipeMapper.selectByPrimaryKey(rid);
        RecipeDetail detail = new RecipeDetail();
        detail.setTid(recipe.getTid());
        detail.setRid(recipe.getRid());
        detail.setPhotoUrl(recipe.getPhotoUrl());
        detail.setDetail(recipe.getDetail());
        detail.setName(recipe.getName());

        //
        List<Map<String, Object>> tmp = gson.fromJson(recipe.getIngredient(),
                new TypeToken<List<Map<String, Object>>>(){}.getType());
        Map<String, String> ingredient = new HashMap<>();
        Map<String, Integer> nutritions = new HashMap<>();
        nutritions.put("热量", 0);
        nutritions.put("碳水", 0);
        nutritions.put("蛋白质", 0);
        nutritions.put("脂肪", 0);
        tmp.forEach(item -> {
            Double fid = (Double) item.get("fid");
            String amount = (String) item.get("amount");
            Food food = foodMapper.selectByPrimaryKey(fid.intValue());
            ingredient.put(food.getName(), amount);
            Map<String, String> nutrition = gson.fromJson(food.getIngredient(),
                    new TypeToken<Map<String, String>>(){}.getType());
            Integer kcal =  nutritions.get("热量");
            kcal += ((Double)Double.parseDouble(nutrition.get("热量"))).intValue();
            nutritions.put("热量", kcal);
            Integer ts =  nutritions.get("碳水");
            ts += ((Double)Double.parseDouble(nutrition.get("碳水"))).intValue();
            nutritions.put("碳水", ts);
            Integer dbz =  nutritions.get("蛋白质");
            dbz += ((Double)Double.parseDouble(nutrition.get("蛋白质"))).intValue();
            nutritions.put("蛋白质", dbz);
            Integer zf =  nutritions.get("脂肪");
            zf += ((Double)Double.parseDouble(nutrition.get("脂肪"))).intValue();
            nutritions.put("脂肪", zf);
        });
        detail.setIngredient(ingredient);
        detail.setNutritions(nutritions);

        return detail;
    }

    @Override
    public List<Food> getFoods() {
        return foodMapper.getAll();
    }

    @Override
    public List<Food> getFoodsByType(int tid) {
        return foodMapper.getFoodsByType(tid);
    }

    @Override
    public Food getFoodDetail(int fid) {
        return foodMapper.selectByPrimaryKey(fid);
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
