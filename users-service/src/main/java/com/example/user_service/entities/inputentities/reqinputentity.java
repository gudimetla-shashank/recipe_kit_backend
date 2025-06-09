package com.example.user_service.entities.inputentities;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@With
public class reqinputentity {

        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String password;
}
