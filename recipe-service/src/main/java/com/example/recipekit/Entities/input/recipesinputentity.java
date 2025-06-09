package com.example.recipekit.Entities.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.With;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@With
public class recipesinputentity {

    private long id;

    @NotBlank(message = "recipe-name is mandatory")
    private String recipename;

    @NotEmpty(message = "ingredients are mandatory")
    private String ingredients[];

    @Positive(message = "cost is mandatory")
    private double cost;

}
