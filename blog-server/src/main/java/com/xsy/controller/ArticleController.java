package com.xsy.controller;



import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;
import com.xsy.domain.Page;
import com.xsy.mapper.ArticleMapper;
import com.xsy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    public ArticleMapper articleMapper;


    @RequestMapping("/getArticle")
    public PageInfo<Article> getAritcle(@RequestBody Page page){

        return articleService.getArtcle(page);
    }


    @RequestMapping("/queryOne")
    public Article queryOne(@RequestBody Article article){
        return articleService.queryOne(article.getId());
    }

    @RequestMapping("/uploadImg")
    public String uploadImg(MultipartFile file) throws IOException {
        String name=articleService.upload(file);
        return "http://qvv2u62qk.hn-bkt.clouddn.com/"+name;

    }

    @RequestMapping("/addArticle")
    public String addArticle(@RequestBody Article article){

        article.setCreateDate(new Date());
        article.setLooknum(0);
        articleService.addArticle(article);
        return "200";
    }

    @RequestMapping("/addCount")
    public void addCount(@RequestParam("id") int id){
        System.out.println(id+"adf");

        articleService.addCount(id);
    }

    @RequestMapping("/getRecommend")
    public List<Article> getRecommend(){
        return articleService.getRecommend();

    }



}
