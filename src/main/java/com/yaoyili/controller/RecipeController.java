package com.yaoyili.controller;

import com.yaoyili.model.Food;
import com.yaoyili.model.Recipe;
import com.yaoyili.model.RecipeDetail;
import com.yaoyili.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
//@ResponseStatus(HttpStatus.OK)
@RequestMapping(value = "recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "{tid}/{uid}")
    public ResponseWrapper getRecipesByType(@PathVariable(value = "tid")int tid,
                                            @PathVariable(value = "uid")int uid) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                recipeService.getRecipesByType(tid, uid));
    }

    @GetMapping(value = "detail/{rid}")
    public ResponseWrapper getRecipeDetail(@PathVariable(value = "rid")int rid) {
        return new ResponseWrapper<RecipeDetail>(
                200, "SUCCESS",
                recipeService.getRecipeDetail(rid));
    }

    @GetMapping(value = "type")
    public ResponseWrapper getRecipeType() {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                recipeService.getRecipeType());
    }

    @GetMapping(value = "foods")
    public ResponseWrapper getFoods() {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                recipeService.getFoods());
    }

    @GetMapping(value = "food/{fid}")
    public ResponseWrapper getFoodDetail(@PathVariable(value = "fid") int fid) {
        return new ResponseWrapper<Food>(
                200, "SUCCESS",
                recipeService.getFoodDetail(fid));
    }


    @GetMapping(value = "foods/{tid}")
    public ResponseWrapper getFoodsByType(@PathVariable(value = "tid")int tid) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                recipeService.getFoodsByType(tid));
    }

    @GetMapping(value = "collects/{uid}")
    public ResponseWrapper getRecipesByUser(@PathVariable(value = "uid")int uid) {
        return new ResponseWrapper<List>(
                200, "SUCCESS",
                recipeService.getRecipesByUser(uid));
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
