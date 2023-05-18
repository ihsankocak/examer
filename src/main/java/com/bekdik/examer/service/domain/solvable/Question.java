package com.bekdik.examer.service.domain.solvable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String problem;
    @Column(nullable = false)
    private String solution;
    @Column(nullable = false)
    private List<String> choices;

}
