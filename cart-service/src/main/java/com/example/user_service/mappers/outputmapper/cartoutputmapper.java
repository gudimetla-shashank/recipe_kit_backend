package com.example.user_service.mappers.outputmapper;

import com.example.user_service.entities.output.CartOutputEntity;
import com.example.user_service.model.cartmodel;
import org.springframework.stereotype.Component;

@Component
public class cartoutputmapper {

    public cartmodel OEtomodel(CartOutputEntity output){
        return cartmodel.builder()
                .id(output.getId())
                .userid(output.getUserid())
                .recipes(output.getRecipes())
                .build();
    }

    public CartOutputEntity modeltoOE(cartmodel model){
        return CartOutputEntity.builder()
                .id(model.getId())
                .userid(model.getUserid())
                .recipes(model.getRecipes())
                .build();
    }
}
