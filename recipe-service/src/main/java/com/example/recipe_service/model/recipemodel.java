package com.example.recipe_service.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
@With
public class recipemodel {

    private long id;
    private String recipename;
    private String ingredients[];
    private double cost;

}
