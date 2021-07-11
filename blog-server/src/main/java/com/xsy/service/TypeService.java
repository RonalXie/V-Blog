package com.xsy.service;

import com.xsy.domain.Page;
import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;

import com.xsy.domain.Type;

import java.util.List;

public interface TypeService {

    public List<Type> getType();

    public int typeSum();

    public void updateType(Type type);

    public void deleteType(Type type);

    int addType(Type type);
    Type getArticleByTid(int tid);

    public PageInfo<Article> queryByType(Page page, int tid);
}
