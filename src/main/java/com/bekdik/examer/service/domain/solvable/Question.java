package com.bekdik.examer.service.domain.solvable;

import com.bekdik.examer.service.domain.exam.Exam;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.BiPredicate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Question{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String problem;

    @Column(nullable = false)
    private String solution;
    @Column(nullable = false)
    private List<String> choices;

    @ManyToOne
    @JoinColumn(name = "exam_id", insertable = false, updatable = false)
    private Exam exam;

}
