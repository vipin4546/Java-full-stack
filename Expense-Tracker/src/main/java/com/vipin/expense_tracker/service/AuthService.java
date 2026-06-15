package com.vipin.expense_tracker.service;

import com.vipin.expense_tracker.dto.AuthResponse;
import com.vipin.expense_tracker.dto.LoginRequest;
import com.vipin.expense_tracker.dto.SignupRequest;
import com.vipin.expense_tracker.entity.User;
import com.vipin.expense_tracker.repository.UserRepository;
import com.vipin.expense_tracker.security.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            BCryptPasswordEncoder encoder,
            JwtService jwtService
    ) {

        this.userRepository = userRepository;

        this.encoder = encoder;

        this.jwtService = jwtService;
    }

    public AuthResponse signup(
            SignupRequest request
    ) {

        if (
                userRepository.existsByEmail(
                        request.getEmail()
                )
        ) {

            throw new RuntimeException(
                    "Email already exists"
            );
        }

        User user = new User();

        user.setName(
                request.getName()
        );

        user.setEmail(
                request.getEmail()
        );

        user.setPassword(
                encoder.encode(
                        request.getPassword()
                )
        );

        userRepository.save(user);

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return new AuthResponse(token);
    }

    public AuthResponse login(
            LoginRequest request
    ) {

        User user = userRepository

                .findByEmail(
                        request.getEmail()
                )

                .orElseThrow(
                        () ->
                                new RuntimeException(
                                        "User not found"
                                )
                );

        if (
                !encoder.matches(
                        request.getPassword(),

                        user.getPassword()
                )
        ) {

            throw new RuntimeException(
                    "Invalid password"
            );
        }

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return new AuthResponse(token);
    }
}