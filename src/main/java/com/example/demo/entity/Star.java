package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "stars")
public class Star {
    @Id
    @Column(name = "sqn", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sqn_user")
    private User sqnUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sqn_idea")
    private Idea sqnIdea;

}