package dev.fisa.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/main")
    public String showPage() {
        return "index";
    }
}
