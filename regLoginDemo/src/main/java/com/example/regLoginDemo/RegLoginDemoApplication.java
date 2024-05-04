package com.example.regLoginDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.regLoginDemo.appUser")
public class RegLoginDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegLoginDemoApplication.class, args);
	}

}
