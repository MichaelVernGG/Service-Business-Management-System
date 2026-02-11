package com.michael.sbms.service;

import com.michael.sbms.model.Admin;
import com.michael.sbms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    // Simple login method
    public boolean login(String username, String password) {
        Optional<Admin> adminOpt = adminRepository.findByUsername(username);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            return admin.getPassword().equals(password);
        }
        return false;
    }

    // For initial setup, save admin
    public Admin createAdmin(String username, String password) {
        Admin admin = new Admin(username, password);
        return adminRepository.save(admin);
    }
}
