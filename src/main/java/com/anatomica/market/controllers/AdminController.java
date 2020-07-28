package com.anatomica.market.controllers;

import com.anatomica.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    public UsersService usersService;

    @Autowired
    public AdminController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String showUser(Model model) {
        model.addAttribute("user", usersService);
        return "admin_page";
    }

    @GetMapping("/block/{id}")
    public String blockUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", usersService);
        usersService.blockById(id);
        return "redirect:/admin";
    }

}