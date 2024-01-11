package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter

public class Exam {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    @Column
    private String username;

    @OneToMany
private List<Question> questions;
}

