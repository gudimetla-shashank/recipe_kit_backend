package com.example.recipekit.adapter;

import com.example.recipekit.Entities.input.putinputentity;
import com.example.recipekit.Service.recipeService;
import com.example.recipekit.commons.putcommonadapter;
import com.example.recipekit.model.recipemodel;
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
