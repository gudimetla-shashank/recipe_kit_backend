package com.example.recipekit.repository.jpa;

import com.example.recipekit.Entities.output.recipesoutputentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface recipeJPARepository extends JpaRepository<recipesoutputentity,Long> {

    List<recipesoutputentity> findByCostBetween(double costStart, double costEnd);
}
