package com.example.user_service.model;

import com.example.recipe_service.model.recipemodel;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class cartmodel {
    private Long id;
    private Long userid;
    private List<recipemodel> recipes;
}
