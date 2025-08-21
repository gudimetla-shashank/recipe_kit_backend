package com.example.user_service.models;

import com.example.user_service.enums.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;
import java.time.ZonedDateTime;

@Data
@Builder
@With
public class Usermodel {
    private Long ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String Password;
    private ZonedDateTime CreatedAt;
    private ZonedDateTime UpdatedAt;
    private UserRole role;
}
