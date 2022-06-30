package com.example.demo.projection;

import com.example.demo.entity.Idea;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.util.List;

@Projection(name = "ideaView",
        types = { Idea.class })
public interface IdeaView {

    @Value("#{target.id}")
    Long getId();

    String getHeadText();

    String getBodyText();

    LocalDate getDate();

    List<CommentView> getComments();

    @Value("#{target.getComments.size()}")
    int getCommentsCount();

    User getUser();

}
