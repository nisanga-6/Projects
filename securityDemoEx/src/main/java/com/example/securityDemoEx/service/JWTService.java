package com.example.securityDemoEx.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Map;
import java.util.function.Function;

public interface JWTService {

    public String generateToken(UserDetails userDetails);
    public String generateRefreshToken(Map<String,Object> extraClaims, UserDetails userDetails);
    public Key getSignInKey();
    public Claims extractAllClaims(String token);
    public<T>T extractClaim(String token, Function<Claims,T> claimsResolvers);
    public String extractUserName(String token);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
