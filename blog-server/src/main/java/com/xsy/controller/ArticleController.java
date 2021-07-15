package com.xsy.controller;



import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;
import com.xsy.domain.Page;
import com.xsy.mapper.ArticleMapper;
import com.xsy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        article.setCreateDate(date);
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

    @RequestMapping("/updateArticle")
    public String updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return "200";

    }

    @RequestMapping("/deleteArticle")
    public String deleteArticle(@RequestBody Article article){
        int id=article.getId();
        articleService.deleteArticle(id);
        return "200";
    }

    @RequestMapping("/lookSum")
    public int lookSum(){
        return articleService.lookSum();
    }

    @RequestMapping("/articleSum")
    public int articleSum(){
        return articleService.articleSum();
    }

    @RequestMapping("/selectRecent")
    public List<Article> selectRecent(){
        return articleService.selectRecent();
    }


    @RequestMapping("/queryTop")
    public List<Article> queryTop(){
        return articleService.queryTop();

    }

    @RequestMapping("/updateTop")
    public void updateTop(@RequestBody Article article){
        System.out.println(article.getIstop());
        articleService.updateTop(article);

    }

    @RequestMapping("/uploadMD")
    public String uploadMD(MultipartFile file) throws IOException {

        articleService.uploadMD(file);
        return "200";

    }

    @RequestMapping("/search")
    public PageInfo<Article> search(int pageNum, int pageSize, String key){
        Page page=new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return articleService.search(page,key);

    }

}
