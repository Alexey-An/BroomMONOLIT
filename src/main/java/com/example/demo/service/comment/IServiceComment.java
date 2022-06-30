package com.example.demo.service.comment;

import com.example.demo.entity.Comment;
import com.example.demo.model.CommentModel;

import java.util.List;

public interface IServiceComment {

    void createComment(CommentModel commentModel);

    List<Comment> getComments();
}
