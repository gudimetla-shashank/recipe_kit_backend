package com.example.user_service.entities.outputentities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@JsonPropertyOrder({ "id", "firstName", "lastName", "email", "phoneNumber", "password" })
@Entity
@Data
@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "Email"),
        @UniqueConstraint(columnNames = "Phonenumber")
        }
)

public class outputentity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="FirstName", nullable = false)
    private String FirstName;

    @Column(name="LastName", nullable = false)
    private String LastName;

    @Column(name = "Email", nullable = false, unique = true)
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "Phonenumber", nullable = false, unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phonenumber;

    @Column(name = "Password", nullable = false)
    private String Password;
}