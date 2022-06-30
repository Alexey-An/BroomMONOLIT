package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "star_broom")
public class Star {
    @Id
    @Column(name = "sqn", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_sqn", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "idea_sqn", nullable = false)
    private Idea idea;
}