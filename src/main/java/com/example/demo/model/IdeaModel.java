package com.example.demo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IdeaModel {

    private String headText;

    private String bodyText;

    private LocalDate date;

    private Long userId;
}
