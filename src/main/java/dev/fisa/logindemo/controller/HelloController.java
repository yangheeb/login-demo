package dev.fisa.logindemo.controller;

import dev.fisa.logindemo.model.User;
import dev.fisa.logindemo.service.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/main")
    public String showPage() {
        return "index";
    }

    @GetMapping("/user")
    public String showUserPage(Model model) {

        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) object;
        model.addAttribute("username", userDetails.getUsername());
        return "user";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails userDetails = (CustomUserDetails) object;
        model.addAttribute("username", userDetails.getUsername());
        return "admin";
    }
}
