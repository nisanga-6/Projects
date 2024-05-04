package com.example.securityDemoEx.serviceIMPL;

import com.example.securityDemoEx.dto.JwtAuthenticationResponse;
import com.example.securityDemoEx.dto.RefreshTokenRequest;
import com.example.securityDemoEx.dto.SignInRequest;
import com.example.securityDemoEx.dto.SignUpRequest;
import com.example.securityDemoEx.entities.Role;
import com.example.securityDemoEx.entities.User;
import com.example.securityDemoEx.repo.UserRepository;
import com.example.securityDemoEx.service.AuthenticationService;
import com.example.securityDemoEx.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    @Override
    public User signUp(SignUpRequest signUpRequest) {
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return userRepository.save(user);
    }


    public JwtAuthenticationResponse signIn(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));
     var user=   userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Username or Password is Invalid"));
     var jwt=jwtService.generateToken(user);
      var refreshToken= jwtService.generateRefreshToken(new HashMap<>(),user);
      JwtAuthenticationResponse jwtAuthenticationResponse= new JwtAuthenticationResponse();
      jwtAuthenticationResponse.setToken(jwt);
      jwtAuthenticationResponse.setRefreshToken(refreshToken);
      return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){

      String userEmail=  jwtService.extractUserName(refreshTokenRequest.getToken());
      User user=userRepository.findByEmail(userEmail).orElseThrow();
      if(jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
        var jwt=  jwtService.generateToken(user);
         var refreshToken=         jwtService.generateRefreshToken(new HashMap<>(),user);
          JwtAuthenticationResponse jwtAuthenticationResponse= new JwtAuthenticationResponse();
          jwtAuthenticationResponse.setToken(jwt);
          jwtAuthenticationResponse.setRefreshToken(refreshToken);
          return jwtAuthenticationResponse;
        }
      return null;
    }
}
