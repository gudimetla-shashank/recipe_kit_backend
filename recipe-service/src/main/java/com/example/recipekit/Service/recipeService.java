package com.example.recipekit.Service;

import com.example.recipekit.Entities.input.putinputentity;
import com.example.recipekit.model.recipemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.recipekit.repository.recipeRepository;

import java.util.List;

@Service
public class recipeService {

    private final recipeRepository recipeRepository;

    @Autowired
    public recipeService(recipeRepository recipeRepository){
        this.recipeRepository=recipeRepository;
    }

    public recipemodel addrecipe(recipemodel recipemodel){
        return this.recipeRepository.save(recipemodel);
    }

    public recipemodel getrecipe(long Id){
        return this.recipeRepository.findByID(Id);
    }

    public List<recipemodel> getall(){
        return this.recipeRepository.getall();
    }

    public recipemodel update(recipemodel recipemodel){
        return this.recipeRepository.update(recipemodel);
    }

    public List<recipemodel> addAll(List<recipemodel> model){
        return this.recipeRepository.saveall(model);
    }

    public recipemodel requpdate(Long Id, putinputentity putinputentity){
        return this.recipeRepository.requpdate(Id, putinputentity);
    }

    public void delete(long Id){
        this.recipeRepository.delete(Id);
    }

    public List<recipemodel> getbetween(Double start, Double end){
        return this.recipeRepository.findByCostBetween(start, end);
    }


}
