package com.xsy.controller;



import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;

import com.xsy.domain.Page;
import com.xsy.domain.Type;
import com.xsy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/typeSum")
    public int typeSum(){
        return typeService.typeSum();
    }

    @RequestMapping("/updateType")
    public int updateType(@RequestBody Type type){
        typeService.updateType(type);
        return 200;
    }


    @RequestMapping("/deleteType")
    public int deleteType(@RequestBody Type type){
        typeService.deleteType(type);
        return 200;
    }

    @RequestMapping("/addType")
    public int addType(@RequestBody Type type){

        return typeService.addType(type);
    }

//    @RequestMapping("/getArticleByTid")
//    public Type getArticleByTid(@RequestBody Type type){
//        System.out.println(type.getTid());
//        return typeService.getArticleByTid(type.getTid());
//    }

    @RequestMapping("/getArticleByTid")
    public PageInfo<Article> getArticleByTid(@RequestBody Page page){
        return typeService.queryByType(page,page.getTid());
    }






}
