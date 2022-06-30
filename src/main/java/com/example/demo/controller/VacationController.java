package com.example.demo.controller;

import com.example.demo.model.VacationModel;
import com.example.demo.service.vacation.IServiceVacation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@RequiredArgsConstructor
public class VacationController {

    private final IServiceVacation serviceVacation;

    @PostMapping(value = "/vacations", produces = MediaTypes.HAL_JSON_VALUE)
    @ResponseBody
    public VacationModel createComments(
            @RequestBody VacationModel vacationModel) {
        serviceVacation.createVacation(vacationModel);

        return vacationModel;
    }
}
