package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.Question;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity

public class Exam {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;

    @OneToMany
    @JoinColumn(name = "exam_id")
    Collection<Question> questionDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Question> getQuestionDTOList() {
        return questionDTOList;
    }

    public void setQuestionDTOList(Collection<Question> questionDTOList) {
        this.questionDTOList = questionDTOList;
    }

}
