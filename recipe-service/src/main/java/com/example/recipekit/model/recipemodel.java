package com.example.recipekit.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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
