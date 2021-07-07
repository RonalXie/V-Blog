package com.xsy.mapper;

import com.xsy.domain.Comment;

public interface CommentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);


    int insertSelective(Comment record);


    Comment selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Comment record);


    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}