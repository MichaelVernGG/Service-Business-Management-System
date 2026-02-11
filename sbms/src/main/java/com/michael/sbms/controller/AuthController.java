package com.michael.sbms.controller;

import com.michael.sbms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    // Show login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Handle login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        boolean success = authService.login(username, password);
        if (success) {
            return "redirect:/dashboard"; // Redirect after login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Back to login page
        }
    }
}
