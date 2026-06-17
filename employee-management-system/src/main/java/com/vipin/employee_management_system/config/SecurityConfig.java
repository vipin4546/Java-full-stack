package com.vipin.employee_management_system.config;

import com.vipin.employee_management_system.filter.JwtAuthenticationFilter;
import com.vipin.employee_management_system.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    )
            throws Exception {

        http.authenticationProvider(
                authenticationProvider()
        );

        http.csrf(
                csrf -> csrf.disable()
        );

        http.addFilterBefore(

                jwtAuthenticationFilter,

                UsernamePasswordAuthenticationFilter.class

        );

        http.authorizeHttpRequests(

                auth -> auth

                        .requestMatchers(
                                "/departments",

                                "/auth/**"

                        )

                        .permitAll()

                        .requestMatchers(
                                "/employees"

                        )

                        .hasRole("ADMIN")

                        .anyRequest()

                        .authenticated()

        );

        return http.build();
    }

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(
                        customUserDetailsService
                );

        provider.setPasswordEncoder(
                passwordEncoder()
        );

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration
    ) throws Exception {

        return configuration.getAuthenticationManager();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
