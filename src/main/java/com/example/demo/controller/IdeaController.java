package com.example.demo.controller;

import com.example.demo.model.IdeaModel;
import com.example.demo.service.idea.IServiceIdea;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequiredArgsConstructor
public class IdeaController {

    private final IServiceIdea serviceIdea;

    @PostMapping(value = "/ideas", produces = MediaTypes.HAL_JSON_VALUE)
    @ResponseBody
    public IdeaModel createComments(
            @RequestBody IdeaModel ideaModel) {
        serviceIdea.createIdea(ideaModel);

        return ideaModel;
    }
}
