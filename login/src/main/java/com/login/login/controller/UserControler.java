package com.login.login.controller;

import com.login.login.model.User;
import com.login.login.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cadastraruser")
public class UserControler {

    private UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/cadastrar")
    public User cadastrar(@RequestBody User user){
        userService.cadastrar(user);
        return user;
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        return user;
    }

}
