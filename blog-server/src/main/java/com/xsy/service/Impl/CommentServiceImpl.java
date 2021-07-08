package com.xsy.service.Impl;

import com.xsy.domain.Comment;
import com.xsy.mapper.CommentMapper;
import com.xsy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void insert(Comment comment) {
        commentMapper.insert(comment);

    }
}
