package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@Table(name = "idea")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sqn", nullable = false)
    private Long id;

    @Column(name = "text_idea")
    private String textIdea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sqn_user")
    private User sqnUser;
}