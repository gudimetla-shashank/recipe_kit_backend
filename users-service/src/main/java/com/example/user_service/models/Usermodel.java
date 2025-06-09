package com.example.user_service.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

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
}
