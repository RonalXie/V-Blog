package com.xsy.service;

import com.xsy.domain.Comment;

import java.util.List;

public interface CommentService {


    public void insert(Comment comment);
    public List<Comment> getComment();


    void deleteComment(Integer cid);
}
