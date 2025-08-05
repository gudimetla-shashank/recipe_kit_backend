package com.example.user_service.entities.output;

import com.example.recipe_service.model.recipemodel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@With
@Builder
@Data
@Table(name="cart")
@NoArgsConstructor
@AllArgsConstructor
public class CartOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID",nullable = false)
    private Long id;


    @Column(name = "userId", nullable = false)
    private Long userid;

    @Column(name= "recipeId")
    private List<recipemodel> recipes;
}
