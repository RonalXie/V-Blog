package com.xsy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.xsy.domain.Article;
import com.xsy.domain.Page;
import com.xsy.mapper.ArticleMapper;
import com.xsy.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private PageHelper pageHelper;



    public PageInfo<Article> getArtcle(Page page) {
        pageHelper.startPage(page.getPageNum(),page.getPageSize(),"id desc");
        List<Article> list=articleMapper.queryAll();

        PageInfo<Article> article=new PageInfo<>(list);
        return article;
    }

    @Override
    public Article queryOne(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public String upload(MultipartFile file) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "kw2LVapjLWjOmdCwlKGEjduba7lGtJ4QMeSwK-Ze";
        String secretKey = "xfanWenVrwG0KWCcHRT9FdTdVY3P7hqECBd5ZWUc";
        String bucket = "xiesiyu";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = file.getOriginalFilename();
        try {
        ;
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(file.getInputStream(),key,upToken,null, null);
                //解析上传成功的结果
                System.out.println(response.getInfo());
                System.out.println();
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return key;
    }

    @Override
    public String addArticle(Article article) {
        if (article.getAbs()==null){
            article.setAbs(article.getContent().substring(0,400));
        }
        articleMapper.insert(article);
        int aid=article.getId();
        int typeId[]=article.getType();
        for (int tid:typeId) {
            articleMapper.addArtType(aid,tid);
        }
        return null;
    }

    @Override
    public void addCount(int id) {
        articleMapper.addCount(id);
    }

    @Override
    public List<Article> getRecommend() {
        return articleMapper.getRecommend();
    }

    @Override
    public int deleteArtType(int id) {
        return articleMapper.deleteArtType(id);
    }

    @Override
    public void updateArticle(Article article) {
        int type[]=article.getType();
        int aid=article.getId();
        articleMapper.updateByPrimaryKey(article);
        articleMapper.deleteArtType(aid);

        for (int tid: type) {
            articleMapper.addArtType(aid,tid);
        }
    }

    @Override
    public void deleteArticle(int id) {
        articleMapper.deleteByPrimaryKey(id);
        articleMapper.deleteArtType(id);
    }

    @Override
    public int lookSum() {
        return articleMapper.lookSum();
    }

    @Override
    public int articleSum() {
        return articleMapper.articleSum();
    }

    @Override
    public List<Article> selectRecent() {
        return articleMapper.selectRecent();
    }

    @Override
    public List<Article> queryTop() {
        return articleMapper.queryTop();
    }

    @Override
    public void updateTop(Article article) {
        articleMapper.updateTop(article);
    }

    @Override
    public void uploadMD(MultipartFile file) throws IOException {
        String name=file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder=new StringBuilder();
        while(br.ready()) {
            String line = br.readLine();
            stringBuilder.append(line+"\n");
        }
        String content=stringBuilder.toString();
        String abs=null;
        if (content.length()<400){
            abs=content;
        }
        else{
            abs=content.substring(0,400);
        }

        String title=name;
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Article article=new Article();
        article.setTitle(title);
        article.setAbs(abs);
        article.setContent(content);
        article.setCreateDate(date);
        article.setLooknum(0);

        articleMapper.insert(article);


    }

    public PageInfo<Article> search(Page page, String key) {


        pageHelper.startPage(page.getPageNum(),page.getPageSize(),"id desc");
        List<Article> list=articleMapper.selectBylike(key);
        PageInfo<Article> article=new PageInfo<>(list);



        return article;
    }


}
