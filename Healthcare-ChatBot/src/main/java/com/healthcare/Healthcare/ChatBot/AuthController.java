package com.healthcare.Healthcare.ChatBot;

import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already registered.";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "Signup successful.";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {

        return userRepository.findByEmail(user.getEmail())
                .filter(existingUser ->
                        passwordEncoder.matches(
                                user.getPassword(),
                                existingUser.getPassword()
                        ))
                .map(existingUser -> {
                    session.setAttribute("userEmail", existingUser.getEmail());
                    return "Login successful.";
                })
                .orElse("Invalid email or password.");
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logout successful.";
    }
}