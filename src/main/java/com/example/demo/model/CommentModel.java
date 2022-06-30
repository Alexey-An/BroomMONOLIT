package com.example.demo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentModel {

    private String headText;

    private String bodyText;

    private LocalDate date;

    private Long userId;

    private Long ideaId;
}
