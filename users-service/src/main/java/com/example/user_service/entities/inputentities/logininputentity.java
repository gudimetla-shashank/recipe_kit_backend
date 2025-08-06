package com.example.user_service.entities.inputentities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class logininputentity {

    private String email;
    private String password;
}
