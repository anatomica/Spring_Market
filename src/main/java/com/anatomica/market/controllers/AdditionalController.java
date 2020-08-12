package com.anatomica.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdditionalController {

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

    @GetMapping("/logout")
    public String logoutPage() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

}