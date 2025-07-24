package com.example.recipe_service.repository;

import com.example.recipe_service.Entities.input.putinputentity;
import com.example.recipe_service.Entities.output.recipesoutputentity;
import com.example.recipe_service.Exceptions.ResourceNotFoundException;
import com.example.recipe_service.mapper.output.recipeoutputmapper;
import com.example.recipe_service.model.recipemodel;
import com.example.recipe_service.repository.jpa.recipeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class recipeRepository {
    private final recipeJPARepository recipeJPARepository;
    private final recipeoutputmapper recipeoutputmapper;

    @Autowired
    public recipeRepository(recipeJPARepository recipeJPARepository ,recipeoutputmapper recipeoutputmapper){
        this.recipeJPARepository=recipeJPARepository;
        this.recipeoutputmapper=recipeoutputmapper;
    }

     public recipemodel save(recipemodel recipe){
         //model to outputentity
         recipesoutputentity outputentity = this.recipeoutputmapper.modeltoOE(recipe);
         //outputentity to db
         recipesoutputentity savedoutputentity =this.recipeJPARepository.save(outputentity);
         //outputntity to model
         //returning the model
         return this.recipeoutputmapper.OEtomodel(savedoutputentity);
     }

     public recipemodel findByID(long Id){
        recipesoutputentity finddata = this.recipeJPARepository.findById((Id))
                .orElseThrow(() -> new ResourceNotFoundException("Recipe with ID " + Id + " not found"));

        return this.recipeoutputmapper.OEtomodel(finddata);
     }

     public List<recipemodel> getall(){
        return this.recipeJPARepository.findAll().stream()
                 .map(recipeoutputmapper::OEtomodel)
                 .toList();
     }

     public recipemodel update(recipemodel model){
        recipemodel existingModel = this.findByID(model.getId());
        return this.save(model);
     }

     public List<recipemodel> saveall(List<recipemodel> models){
        List<recipemodel> result = new ArrayList<>();
        for(recipemodel model:models){
            result.add(this.save(model));
        }
        return result;
     }

     public recipemodel requpdate(Long Id, putinputentity putinputentity){
         recipemodel data = Optional.ofNullable(this.findByID(Id))
                 .orElseThrow(()->new ResourceNotFoundException("the data with id"+ Id+ "not found"));

         if (putinputentity.getRecipename() != null) data.setRecipename(putinputentity.getRecipename());
         if (putinputentity.getIngredients() != null) data.setIngredients(putinputentity.getIngredients());
         if (putinputentity.getCost() != null) data.setCost(putinputentity.getCost());

         return recipeRepository.this.save(data);
     }

     public List<recipemodel> findByCostBetween(Double costStart, Double costEnd){
        List<recipesoutputentity> entities =  this.recipeJPARepository.findByCostBetween(costStart, costEnd);
        List<recipemodel> result =new ArrayList<>();
        for(recipesoutputentity entity: entities){
            result.add(recipeoutputmapper.OEtomodel(entity));
        }
        return result;
     }

     public void delete(long Id){
         if (!this.recipeJPARepository.existsById(Id)) {
             throw new ResourceNotFoundException("No recipe found with ID: " + Id);
         }
        this.recipeJPARepository.deleteById(Id);
     }

}
