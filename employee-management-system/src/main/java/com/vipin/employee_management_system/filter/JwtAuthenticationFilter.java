package com.vipin.employee_management_system.filter;

import com.vipin.employee_management_system.service.CustomUserDetailsService;
import com.vipin.employee_management_system.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final CustomUserDetailsService customUserDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,

            CustomUserDetailsService customUserDetailsService
    ) {

        this.jwtService = jwtService;

        this.customUserDetailsService =
                customUserDetailsService;

    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        if (
                request.getServletPath()

                        .startsWith("/auth")

        ) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }

        String authHeader =
                request.getHeader("Authorization");

        if (authHeader == null
                || !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(
                    request,
                    response
            );

            return;
        }

        String token =
                authHeader.substring(7);

        String username =
                jwtService.extractUsername(
                        token
                );

        if (username != null
                &&
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        == null) {

            UserDetails userDetails =
                    customUserDetailsService
                            .loadUserByUsername(
                                    username
                            );

            if (jwtService.validateToken(
                    token,
                    username
            )) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(
                                authToken
                        );
            }
        }

        filterChain.doFilter(
                request,
                response
        );
    }
}