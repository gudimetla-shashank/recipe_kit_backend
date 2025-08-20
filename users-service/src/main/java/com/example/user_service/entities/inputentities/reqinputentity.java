package com.example.user_service.entities.inputentities;


import lombok.*;

import java.time.Instant;
import java.time.ZonedDateTime;

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
        private ZonedDateTime updatedAt;
        private ZonedDateTime createdAt;
}
