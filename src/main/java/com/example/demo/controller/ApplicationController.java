package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class ApplicationController {


    @GetMapping({"", "/"})
    public String main(Model model, @Nullable Authentication auth) {
        if (Objects.isNull(auth)) {
           return "login-page";
        }

        User user = (User) auth.getPrincipal();
        model.addAttribute("user", user);

        if (user.hasRole("ROLE_ADMIN")) {
            return "main-page";
        }

        if (user.hasRole("ROLE_USER")) {
            return "user-page";
        }

        return "access-denied-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied-page";
    }
}
