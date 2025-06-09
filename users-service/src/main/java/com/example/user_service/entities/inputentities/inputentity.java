package com.example.user_service.entities.inputentities;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@With
@Builder
@Getter
@Setter
public class inputentity {

    private Long id;

    @NotBlank(message = "first-name is mandatory")
    private String FirstName;

    @NotBlank(message = "last-name is mandatory")
    private String LastName;

    @NotBlank(message = "email is mandatory")
    private String Email;

    @NotBlank(message = "phnumber is mandatory")
    private String PhoneNumber;

    @NotBlank(message = "password is mandatory")
    private String Password;
}
