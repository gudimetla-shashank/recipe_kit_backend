package com.example.recipekit.Entities.output;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name="recipes")
@NoArgsConstructor
@AllArgsConstructor
public class recipesoutputentity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id",nullable = false)
    private long id;

    @Column(name="recipename", nullable =false, length=50)
    private String recipename;

    @Column(name="ingredients", nullable = false)
    private String ingredients[];

    @Column(name="cost", nullable = false, length=10)
    private double cost;


}
