package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "vacation_broom")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sqn", nullable = false)
    private Long id;

    @Column(name = "vacation_start", nullable = false)
    private LocalDate vacationStart;

    @Column(name = "vacation_end", nullable = false)
    private LocalDate vacationEnd;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_sqn", nullable = false)
    private User user;
}