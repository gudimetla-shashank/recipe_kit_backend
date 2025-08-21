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
                .CreatedAt(outputentity.getCreatedAt())
                .UpdatedAt(outputentity.getUpdatedAt())
                .role(outputentity.getRole())
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
                .createdAt(Usermodel.getCreatedAt())
                .updatedAt(Usermodel.getUpdatedAt())
                .role(Usermodel.getRole())
                .build();
    }
}
