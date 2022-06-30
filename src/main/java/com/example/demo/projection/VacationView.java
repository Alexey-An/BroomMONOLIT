package com.example.demo.projection;

import com.example.demo.entity.Comment;
import com.example.demo.entity.User;
import com.example.demo.entity.Vacation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "vacationView",
        types = { Vacation.class })
public interface VacationView {

    @Value("#{target.id}")
    Long getId();

    LocalDate getVacationStart();

    LocalDate getVacationEnd();

    User getUser();
}
