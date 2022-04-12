package com.lab3.journal2.controllers;

import com.lab3.journal2.entities.Role;
import com.lab3.journal2.entities.User;
import com.lab3.journal2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        Role[] roles = Role.values();
        model.addAttribute("user", new User());
        model.addAttribute("roles", roles);
        return "registration";
    }

    @PostMapping
    public String registration(Model model,
                               @ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/registration?success";
    }
}
