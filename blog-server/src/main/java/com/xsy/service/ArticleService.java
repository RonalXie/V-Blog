package com.xsy.service;


import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;
import com.xsy.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface ArticleService {

    public PageInfo<Article> getArtcle(Page page);
    public Article queryOne(int id);
    public String upload(MultipartFile file);
    public String addArticle(Article article);
    public void addCount(int id);

    public List<Article> getRecommend();
    public int deleteArtType(int id);
    public void updateArticle(Article article);
    public void deleteArticle(int id);

    public int lookSum();

    int articleSum();
}
