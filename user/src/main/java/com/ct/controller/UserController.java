package com.ct.controller;

import com.ct.entity.User;
import com.ct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("/test")
    public String getUser(){
        User byId = userService.getById();
        return byId.toString();
    }
}
