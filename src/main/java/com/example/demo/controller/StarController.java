package com.example.demo.controller;

import com.example.demo.model.StarModel;
import com.example.demo.service.star.IServiceStar;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequiredArgsConstructor
public class StarController {

    private final IServiceStar serviceStar;

    @PostMapping(value = "/stars", produces = MediaTypes.HAL_JSON_VALUE)
    @ResponseBody
    public StarModel createComments(
            @RequestBody StarModel starModel) {
        serviceStar.createStar(starModel);

        return starModel;
    }
}
