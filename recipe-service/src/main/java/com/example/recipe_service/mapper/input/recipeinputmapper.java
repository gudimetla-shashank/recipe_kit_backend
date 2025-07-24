package com.example.recipe_service.mapper.input;

import com.example.recipe_service.Entities.input.recipesinputentity;
import com.example.recipe_service.model.recipemodel;
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
