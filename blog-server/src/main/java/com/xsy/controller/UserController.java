package com.xsy.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;
import com.xsy.domain.User;
import com.xsy.mapper.ArticleMapper;
import com.xsy.mapper.UserMapper;
import com.xsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getUser")
    public User getUser(@RequestBody User user){
        user=userService.getUser(user.getId());
        user.setPassword(null);
        return user;
    }

    @RequestMapping("/login")
    public User login(@RequestBody User user){
        System.out.println(user.getUsername());
        return userService.login(user);
    }




}
