package com.lab3.journal2.controllers;

import com.lab3.journal2.services.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@Secured("ROLE_ADMIN")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/delete")
    public String removeUserByName(@RequestParam String name) {
        userService.deleteUser(name);
        return "redirect:/users";
    }
}
