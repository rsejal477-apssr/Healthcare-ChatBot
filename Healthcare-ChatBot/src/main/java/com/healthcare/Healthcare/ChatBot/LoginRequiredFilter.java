package com.healthcare.Healthcare.ChatBot;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class LoginRequiredFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if ("/index.html".equals(path)) {
            HttpSession session = request.getSession(false);

            if (session == null ||
                    session.getAttribute("userEmail") == null) {

                response.sendRedirect(
                        request.getContextPath() + "/login.html");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
