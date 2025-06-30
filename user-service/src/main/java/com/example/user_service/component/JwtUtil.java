package com.example.user_service.component;

import java.util.Date;

import org.bouncycastle.jcajce.BCFKSLoadStoreParameter.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "secret123";   // Secret key used for signing the JWT tokens

    public String generateToken(String email) {
        return Jwts.builder()                      // Create a JWT token with the provided email
                .setSubject(email)                 // Set the subject of the token to the email
                .setIssuedAt(new Date())           // Set the issued date of the token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))   // Set the expiration date of the token to 1 hour from now  
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();     // Sign the token with the secret key using HS256 algorithm
    }

    public String extractEmail(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)       // Parse the JWT token using the secret key
                .parseClaimsJws(token).getBody().getSubject(); // Extract the subject (email) from the token claims
    }

}
