package com.example.recipe_service.adapter;

import com.example.recipe_service.Entities.input.recipesinputentity;
import com.example.recipe_service.Service.recipeService;
import com.example.recipe_service.commons.recipeadaptercommon;
import com.example.recipe_service.mapper.input.recipeinputmapper;
import com.example.recipe_service.model.recipemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class recipeadapter implements recipeadaptercommon<recipesinputentity,recipemodel> {

    private final recipeService recipeService;

    private final recipeinputmapper recipeinputmapper;


    @Autowired
    public recipeadapter(recipeService recipeService ,recipeinputmapper recipeinputmapper){
        this.recipeinputmapper=recipeinputmapper;
        this.recipeService=recipeService;
    }

    @Override
    public recipemodel save(recipesinputentity reciepesinputentity){
        return this.recipeService.addrecipe(this.recipeinputmapper.IEtomodel(reciepesinputentity));
    }

    @Override
    public recipemodel getById(long Id){
        return this.recipeService.getrecipe(Id);
    }

    @Override
    public List<recipemodel> getAll(){
        return this.recipeService.getall();
    }

    @Override
    public recipemodel update(recipesinputentity recipesinputentity){
        return this.recipeService.update(this.recipeinputmapper.IEtomodel(recipesinputentity));
    }

    @Override
    public List<recipemodel> addAll(List<recipesinputentity> inputList){
        List<recipemodel> modelList = new ArrayList<>();
        for (recipesinputentity input : inputList) {
            recipemodel model = recipeinputmapper.IEtomodel(input); // convert each input entity to model
            modelList.add(model);
        }
        return this.recipeService.addAll(modelList);
    }

    @Override
    public void delete(long Id){
         this.recipeService.delete(Id);
    }

    @Override
    public List<recipemodel> getbetween(Double start, Double end) {
        return recipeService.getbetween(start, end);
    }

}
