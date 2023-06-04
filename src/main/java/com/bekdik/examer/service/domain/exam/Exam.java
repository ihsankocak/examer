package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity

public class Exam {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String user;
    private byte[] audioRecord;
    @OneToMany
    List<Question> questionDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public byte[] getAudioRecord() {
        return audioRecord;
    }

    public void setAudioRecord(byte[] audioRecord) {
        this.audioRecord = audioRecord;
    }

    public List<Question> getQuestionDTOList() {
        return questionDTOList;
    }

    public void setQuestionDTOList(List<Question> questionDTOList) {
        this.questionDTOList = questionDTOList;
    }
}
