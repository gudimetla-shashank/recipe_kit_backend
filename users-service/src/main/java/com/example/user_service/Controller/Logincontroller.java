package com.example.user_service.Controller;

import com.example.user_service.JWT.JwtUtil;
import com.example.user_service.entities.inputentities.logininputentity;
import com.example.user_service.models.loginmodel;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Logincontroller {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Autowired
    public Logincontroller(AuthenticationManager authenticationManager, JwtUtil jwtUtil,UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService=userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody logininputentity request) {
        try {
            // Authenticate
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            // Load UserDetails
            UserDetails userDetails = userService.loadUserByUsername(request.getEmail());

            // Generate token
            String token = jwtUtil.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new loginmodel(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
