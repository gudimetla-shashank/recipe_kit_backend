package com.example.user_service.mappers.inputmapper;

import com.example.user_service.entities.inputentities.inputentity;
import com.example.user_service.models.Usermodel;
import org.springframework.stereotype.Component;

@Component
public class inputmapper {

    public Usermodel IEtomodel(inputentity inputentity){
        return Usermodel.builder()
                .ID(inputentity.getId())
                .FirstName(inputentity.getFirstName())
                .LastName(inputentity.getLastName())
                .Email(inputentity.getEmail())
                .PhoneNumber(inputentity.getPhoneNumber())
                .Password(inputentity.getPassword())
                .build();
    }

}
