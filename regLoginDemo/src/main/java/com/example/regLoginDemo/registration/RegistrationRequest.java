package com.example.regLoginDemo.registration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegistrationRequest {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
}
