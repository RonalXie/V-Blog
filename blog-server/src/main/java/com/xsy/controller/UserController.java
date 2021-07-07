package com.xsy.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;
import com.xsy.domain.User;
import com.xsy.mapper.ArticleMapper;
import com.xsy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper  articleMapper;

    @Autowired
    private PageHelper pageHelper;

    @RequestMapping("/user")
    public PageInfo<Article> getUser(@RequestBody User user){


        System.out.println(user.getId());


        PageInfo<Article> page=new PageInfo<>();

        return  page;
    }


}
