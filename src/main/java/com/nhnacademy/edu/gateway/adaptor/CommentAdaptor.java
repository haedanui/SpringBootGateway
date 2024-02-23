package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.Comment;
import com.nhnacademy.edu.gateway.domain.Milestone;

import java.util.List;

public interface CommentAdaptor {
    List<Comment> getComments();

    Comment getComment(Long commentNumber);

    void createComment(Comment comment);
}
