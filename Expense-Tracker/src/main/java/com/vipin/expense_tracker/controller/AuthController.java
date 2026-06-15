package com.vipin.expense_tracker.controller;

import com.vipin.expense_tracker.dto.AuthResponse;
import com.vipin.expense_tracker.dto.LoginRequest;
import com.vipin.expense_tracker.dto.SignupRequest;
import com.vipin.expense_tracker.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/auth")

public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService
    ) {

        this.authService = authService;
    }

    @PostMapping("/signup")

    public AuthResponse signup(

            @Valid

            @RequestBody

            SignupRequest request

    ) {

        return authService.signup(
                request
        );
    }

    @PostMapping("/login")

    public AuthResponse login(

            @Valid

            @RequestBody

            LoginRequest request

    ) {

        return authService.login(
                request
        );
    }
}