package com.example.user_service.mappers.inputmapper;

import com.example.user_service.entities.input.cartinputentity;
import com.example.user_service.model.cartmodel;
import org.springframework.stereotype.Component;

@Component
public class cartinputmapper {

    public cartmodel IEtomodel(cartinputentity cartinputentity){
        return cartmodel.builder()
                .userid(cartinputentity.getUserid())
                .recipes(cartinputentity.getRecipes())
                .build();
    }
}
