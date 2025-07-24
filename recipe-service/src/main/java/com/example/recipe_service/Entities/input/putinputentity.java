package com.example.recipe_service.Entities.input;

import lombok.*;

@Data
@Builder
@With
public class putinputentity {

    private String recipename;
    private String ingredients[];
    private Double cost;
}
