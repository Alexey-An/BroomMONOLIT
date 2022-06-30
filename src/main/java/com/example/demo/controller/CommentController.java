package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.service.comment.IServiceComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequiredArgsConstructor
public class CommentController {

    private final IServiceComment serviceComment;

    @PostMapping(value = "/comments", produces = MediaTypes.HAL_JSON_VALUE)
    @ResponseBody
    public void createComments(
            @RequestBody CommentModel commentModel) {
        serviceComment.createComment(commentModel);
    }

}
