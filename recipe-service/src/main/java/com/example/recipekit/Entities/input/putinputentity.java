package com.example.recipekit.Entities.input;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@With
public class putinputentity {

    private String recipename;
    private String ingredients[];
    private Double cost;
}
