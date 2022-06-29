package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "sqn", nullable = false)
    private Long id;

    @Column(name = "text_comment")
    private String textComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sqn_user")
    private User sqnUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sqn_idea")
    private Idea sqnIdea;
}