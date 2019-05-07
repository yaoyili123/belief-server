package com.yaoyili.controller;

import com.yaoyili.dao.UserCollectRecipeMapper;
import com.yaoyili.model.ResponseWrapper;
import com.yaoyili.model.UserInfo;
import com.yaoyili.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
//@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "collects/{uid}")
    public ResponseWrapper getRecipes(@PathVariable(value = "uid")int uid) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                recipeService.getRecipes(uid));
    }

    @PutMapping(value = "collects/{uid}/{rid}")
    public ResponseWrapper addRecipe(@PathVariable(value = "uid")int uid, @PathVariable(value = "rid")int rid) {
        recipeService.addRecipe(uid, rid);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }

    @DeleteMapping(value = "collects/{uid}/{rid}")
    public ResponseWrapper deleteRecipe(@PathVariable(value = "uid")int uid, @PathVariable(value = "rid")int rid) {
        recipeService.deleteRecipe(uid, rid);
        return new ResponseWrapper<Object>(
                200, "SUCCESS",
                new HashMap<>());
    }
}
