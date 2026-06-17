package com.vipin.employee_management_system.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey12345";

    private SecretKey getSignInKey() {

        return Keys.hmacShaKeyFor(
                SECRET.getBytes()
        );

    }

    public String generateToken(
            String username
    ) {

        return Jwts.builder()

                .subject(username)

                .signWith(
                        getSignInKey()
                )

                .compact();

    }

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username);
    }

}