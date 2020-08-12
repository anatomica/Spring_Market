package com.anatomica.market.controllers;

import com.anatomica.market.entities.User;
import com.anatomica.market.entities.dtos.SystemUser;
import com.anatomica.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

@Controller
public class RegistrationController {
    private UsersService usersService;

    @Autowired
    public void setUserService(UsersService usersService) {
        this.usersService = usersService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String showMyLoginPage(Model model) {
        model.addAttribute("systemUser", new SystemUser());
        return "registration-form";
    }

    @PostMapping("/register/process")
    public String processRegistrationForm(@ModelAttribute("systemUser") @Validated SystemUser systemUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration-form";
        }
        Optional<User> existing = usersService.findByEmail(systemUser.getEmail());
        if (existing.isPresent()) {
            model.addAttribute("registrationError", "User with E-mail: [" + systemUser.getEmail() + "] is already exist");
            systemUser.setEmail(null);
            model.addAttribute("systemUser", systemUser);
            return "registration-form";
        }
        usersService.save(systemUser);
        return "registration-confirmation";
    }
}
