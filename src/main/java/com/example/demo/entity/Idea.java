package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "idea_broom")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sqn", nullable = false)
    private Long id;

    @Column(name = "head_text")
    private String headText;

    @Column(name = "body_text")
    private String bodyText;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "sqn_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "idea", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments;
}