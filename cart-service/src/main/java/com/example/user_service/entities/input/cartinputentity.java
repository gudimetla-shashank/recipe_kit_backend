package com.example.user_service.entities.input;

import com.example.recipe_service.model.recipemodel;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class cartinputentity {

    @NotBlank(message = "userid should not be null")
    private Long userid;

    @NotBlank(message = "recipeid should not be null")
    private List<recipemodel> recipes;
}
