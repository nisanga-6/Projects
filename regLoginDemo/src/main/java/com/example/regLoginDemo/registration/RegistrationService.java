package com.example.regLoginDemo.registration;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
    boolean isValidEmail =    emailValidator.test(request.getEmail());
    if(!isValidEmail){
        throw new IllegalStateException("Email is not valid");
    }
        return "works";
    }
}
