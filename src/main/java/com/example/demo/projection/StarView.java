package com.example.demo.projection;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Idea;
import com.example.demo.entity.Star;
import com.example.demo.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "starView",
        types = { Star.class })
public interface StarView {

    Idea getIdea();

    User getUser();
}
