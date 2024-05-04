package com.example.securityDemoEx.serviceIMPL;

import com.example.securityDemoEx.repo.UserRepository;
import com.example.securityDemoEx.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserDetailsService userDetailsService(){

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username)  {
                return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
            }
        };
    }
}
