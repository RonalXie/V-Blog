package com.xsy.mapper;

import com.xsy.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> queryAll();

    int addArtType(int aid,int tid);

    int lookSum();

    int addCount(int id);

    List<Article> getRecommend();

    int deleteArtType(int id);

    int articleSum();
    List<Article> selectRecent();

    List<Article> queryTop();

    void updateTop(Article article);
}