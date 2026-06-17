package com.vipin.employee_management_system.service;

import com.vipin.employee_management_system.dto.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return jwtService.generateToken(request.getUsername());
    }
}
