package com.example.securityDemoEx.service;

import com.example.securityDemoEx.dto.JwtAuthenticationResponse;
import com.example.securityDemoEx.dto.RefreshTokenRequest;
import com.example.securityDemoEx.dto.SignInRequest;
import com.example.securityDemoEx.dto.SignUpRequest;
import com.example.securityDemoEx.entities.User;

public interface AuthenticationService {
    public User signUp(SignUpRequest signUpRequest);
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
