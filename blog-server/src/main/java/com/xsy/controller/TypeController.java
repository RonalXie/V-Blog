package com.xsy.controller;


import com.xsy.domain.Type;
import com.xsy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TypeController {

    @Autowired
    private TypeService typeService;


    @RequestMapping("/getType")
    public List<Type> getType(){

        return typeService.getType();
    }






}
