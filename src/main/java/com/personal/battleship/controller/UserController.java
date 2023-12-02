package com.personal.battleship.controller;

import com.personal.battleship.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }
    @PostMapping("/login")
    public Boolean login() {
        return false;
    }
    @PostMapping("/register")
    public Boolean register() {
        return false;
    }
    @GetMapping("/logout")
    public Boolean logout() {
        return false;
    }
    @PutMapping("/changeName")
    public Boolean changeName() {
        return false;
    }

}
