package com.vipin.expense_tracker.service;

import com.vipin.expense_tracker.entity.User;
import com.vipin.expense_tracker.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {

        this.userRepository = userRepository;
    }

    public User getCurrentUser(
            Authentication authentication
    ) {

        String email = authentication.getName();

        return userRepository

                .findByEmail(
                        email
                )

                .orElseThrow(

                        () ->

                                new RuntimeException(
                                        "User not found"
                                )

                );
    }
}