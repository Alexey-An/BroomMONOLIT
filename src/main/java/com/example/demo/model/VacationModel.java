package com.example.demo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VacationModel {

    private LocalDate vacationStart;

    private LocalDate vacationEnd;

    private Long userId;
}
