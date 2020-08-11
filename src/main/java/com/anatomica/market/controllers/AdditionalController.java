package com.anatomica.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdditionalController {
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/login_dev")
    public String loginPage() {
        return "login_page";
    }

    @GetMapping("/login")
    public String loginPageJS() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}