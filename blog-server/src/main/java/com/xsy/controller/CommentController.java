package com.xsy.controller;


import com.xsy.domain.Comment;
import com.xsy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {


    @Autowired
    private CommentService commentService;
    @RequestMapping("/addComment")
    public void addComment(@RequestBody Comment comment){

        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        comment.setDate(date);
        System.out.println(comment.getaId());
        commentService.insert(comment);
    }

}
