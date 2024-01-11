package com.bekdik.examer.service.domain.exam.student;

import com.bekdik.examer.application.auth.client.user.ApplicationUser;
import com.bekdik.examer.service.domain.exam.Exam;
import com.bekdik.examer.service.domain.solvable.BaseSolvable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Getter
@Setter
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private ApplicationUser student;

@ManyToOne
    private Exam exam;

    private String studentSolution;
}
