package com.example.recipekit.mapper.input;

import com.example.recipekit.Entities.input.recipesinputentity;
import com.example.recipekit.model.recipemodel;
import org.springframework.stereotype.Component;

@Component
public class recipeinputmapper {

    public recipemodel IEtomodel(recipesinputentity recipesinputentity){
        return recipemodel.builder()
                .id(recipesinputentity.getId())
                .recipename(recipesinputentity.getRecipename())
                .ingredients(recipesinputentity.getIngredients())
                .cost(recipesinputentity.getCost())
                .build();
    }
}
