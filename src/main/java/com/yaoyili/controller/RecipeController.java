package com.yaoyili.controller;

import com.yaoyili.dao.UserCollectRecipeMapper;
import com.yaoyili.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "collects/{uid}")
    public List<Integer> getRecipes(@PathVariable(value = "uid")int uid) {
        return recipeService.getRecipes(uid);
    }

    @PutMapping(value = "collects/{uid}/{rid}")
    public String addRecipe(@PathVariable(value = "uid")int uid, @PathVariable(value = "rid")int rid) {
        recipeService.addRecipe(uid, rid);
        return "success";
    }

    @DeleteMapping(value = "collects/{uid}/{rid}")
    public String deleteRecipe(@PathVariable(value = "uid")int uid, @PathVariable(value = "rid")int rid) {
        recipeService.deleteRecipe(uid, rid);
        return "success";
    }
}
