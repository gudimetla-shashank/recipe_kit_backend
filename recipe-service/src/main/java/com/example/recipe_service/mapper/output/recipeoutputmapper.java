package com.example.recipe_service.mapper.output;

import com.example.recipe_service.Entities.output.recipesoutputentity;
import com.example.recipe_service.model.recipemodel;
import org.springframework.stereotype.Component;

@Component
public class recipeoutputmapper {

    public recipemodel OEtomodel(recipesoutputentity recipesoutputentity){
        return recipemodel.builder()
                .id(recipesoutputentity.getId())
                .recipename(recipesoutputentity.getRecipename())
                .ingredients(recipesoutputentity.getIngredients())
                .cost(recipesoutputentity.getCost())
                .build();
    }

    public recipesoutputentity modeltoOE(recipemodel recipemodel){
        return recipesoutputentity.builder()
                .id(recipemodel.getId())
                .recipename(recipemodel.getRecipename())
                .ingredients(recipemodel.getIngredients())
                .cost(recipemodel.getCost())
                .build();
    }

}
