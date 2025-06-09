package com.example.user_service.adapters;

import com.example.user_service.commonadapter.reqcommonadapter;
import com.example.user_service.entities.inputentities.reqinputentity;
import com.example.user_service.models.Usermodel;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class requpdateadapter implements reqcommonadapter<Usermodel, reqinputentity> {


    private final UserService userService;
    @Autowired
    public requpdateadapter(UserService userService){
        this.userService=userService;
    }

    @Override
    public Usermodel requpdate(Long Id, reqinputentity reqinputentity){
        return userService.requpdate(Id , reqinputentity);
    }

}
