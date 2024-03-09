package com.example.authenticationservice.controllers;

// AuthenticationController.java
import com.example.authenticationservice.model.AuthenticationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthenticationRequest request) {
        if ("hamza".equals(request.getUsername()) && "1234f".equals(request.getPassword())) {
            return "Authenticated";
        } else {
            return "Authentication Failed";
        }
    }
}
