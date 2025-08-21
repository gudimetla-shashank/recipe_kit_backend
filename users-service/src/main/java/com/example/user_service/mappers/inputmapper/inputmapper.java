package com.example.user_service.mappers.inputmapper;

import com.example.user_service.entities.inputentities.inputentity;
import com.example.user_service.models.Usermodel;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
                .CreatedAt(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")))
                .role(inputentity.getRole())
                .build();
    }

}
