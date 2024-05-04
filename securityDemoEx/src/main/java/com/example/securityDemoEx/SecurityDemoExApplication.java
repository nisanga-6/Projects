package com.example.securityDemoEx;

import com.example.securityDemoEx.entities.Role;
import com.example.securityDemoEx.entities.User;
import com.example.securityDemoEx.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityDemoExApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      User userAdmin=            userRepository.findByRole(Role.ADMIN);
	  if(userAdmin==null){
		  User user = new User();
		  user.setFirstName("Admin");
		  user.setLastName("Admin");
		  user.setEmail("Admin@gmail.com");
		  user.setRole(Role.ADMIN);
		  user.setPassword(new BCryptPasswordEncoder().encode("ADMIN123"));
		  userRepository.save(user);
	  }
	}
}
