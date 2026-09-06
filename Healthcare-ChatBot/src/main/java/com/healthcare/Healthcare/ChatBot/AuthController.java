package com.healthcare.Healthcare.ChatBot;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already registered.";
        }

        userRepository.save(user);

        return "Signup successful.";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {

        return userRepository.findByEmail(user.getEmail())
                .filter(existingUser ->
                        existingUser.getPassword().equals(user.getPassword()))
                .map(existingUser -> {
                    session.setAttribute("userEmail", existingUser.getEmail());
                    return "Login successful.";
                })
                .orElse("Invalid email or password.");
    }
}
