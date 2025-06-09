package com.example.user_service.mappers.outputmapper;

import com.example.user_service.entities.outputentities.outputentity;
import com.example.user_service.models.Usermodel;
import org.springframework.stereotype.Component;

@Component
public class outputmapper {

    public Usermodel OEtomodel(outputentity outputentity){
        return Usermodel.builder()
                .ID(outputentity.getId())
                .FirstName(outputentity.getFirstName())
                .LastName(outputentity.getLastName())
                .Email(outputentity.getEmail())
                .PhoneNumber(outputentity.getPhonenumber())
                .Password(outputentity.getPassword())
                .build();
    }

    public outputentity modeltoOE(Usermodel Usermodel){
        return outputentity.builder()
                .id(Usermodel.getID())
                .FirstName(Usermodel.getFirstName())
                .LastName(Usermodel.getLastName())
                .email(Usermodel.getEmail())
                .phonenumber(Usermodel.getPhoneNumber())
                .Password(Usermodel.getPassword())
                .build();
    }
}
