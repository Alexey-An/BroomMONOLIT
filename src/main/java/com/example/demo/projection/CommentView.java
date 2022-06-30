package com.example.demo.projection;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Idea;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "commentView",
        types = { Comment.class })
public interface CommentView {

    @Value("#{target.id}")
    Long getId();

    String getHeadText();

    String getBodyText();

    LocalDate getDate();

    User getUser();
}
