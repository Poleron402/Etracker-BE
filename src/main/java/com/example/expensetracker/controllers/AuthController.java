package com.example.expensetracker.controllers;


import com.example.expensetracker.entities.AuthenticationResponse;
import com.example.expensetracker.entities.User;
import com.example.expensetracker.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

    @GetMapping("/api/auth/check")
    public ResponseEntity<?> checkToken(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok().body(token);
    }
}
