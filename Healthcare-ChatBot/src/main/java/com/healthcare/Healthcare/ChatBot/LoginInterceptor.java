package com.healthcare.Healthcare.ChatBot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        String userEmail =
                (String) request.getSession().getAttribute("userEmail");

        if (userEmail == null) {
            response.sendRedirect("/login.html");
            return false;
        }

        return true;
    }
}