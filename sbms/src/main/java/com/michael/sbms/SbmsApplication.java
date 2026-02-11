package com.michael.sbms;

import com.michael.sbms.service.AuthService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmsApplication.class, args);
    }

    @Bean
    CommandLineRunner testAuth(AuthService authService) {
        return args -> {
            // Check if admin exists
            if (!authService.login("admin", "admin123")) { // simple check
                authService.createAdmin("admin", "admin123");
                System.out.println("Admin created!");
            }

            // Test login
            boolean success = authService.login("admin", "admin123");
            System.out.println("Login success? " + success);
        };
    }
}
