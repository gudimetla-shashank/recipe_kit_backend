package com.example.recipe_service.adapter;

import com.example.recipe_service.Entities.input.putinputentity;
import com.example.recipe_service.Service.recipeService;
import com.example.recipe_service.commons.putcommonadapter;
import com.example.recipe_service.model.recipemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class putadapter implements putcommonadapter<recipemodel, putinputentity> {


    private final recipeService recipeService;

    @Autowired
    public putadapter(recipeService recipeService){
        this.recipeService=recipeService;
    }

    @Override
    public recipemodel requpdate(Long Id, putinputentity putinputentity){
        return recipeService.requpdate(Id, putinputentity);
    }


}
