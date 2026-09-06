package com.healthcare.Healthcare.ChatBot;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session) {

        String userEmail =
                (String) session.getAttribute("userEmail");

        if (userEmail == null) {
            return "redirect:/login.html";
        }

        return "redirect:/index.html";
    }
}
