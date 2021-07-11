package com.xsy.service.Impl;

import com.xsy.domain.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsy.domain.Article;

import com.xsy.domain.Type;
import com.xsy.mapper.TypeMapper;
import com.xsy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private PageHelper pageHelper;
    @Override
    public List<Type> getType() {
        return typeMapper.getType();
    }

    @Override
    public int typeSum() {
        return typeMapper.typeSum();
    }

    @Override
    public void updateType(Type type) {
        typeMapper.updateByPrimaryKey(type);
    }

    @Override
    public void deleteType(Type type) {
        typeMapper.deleteByPrimaryKey(type.getTid());
        typeMapper.deleteArtType(type.getTid());
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public Type getArticleByTid(int tid) {
        return null;
    }


    public PageInfo<Article> queryByType(Page page, int tid) {
        pageHelper.startPage(page.getPageNum(),page.getPageSize(),"id desc");
        List<Article> list=typeMapper.queryByType(tid);

        PageInfo<Article> article=new PageInfo<>(list);
        return article;
    }
}
