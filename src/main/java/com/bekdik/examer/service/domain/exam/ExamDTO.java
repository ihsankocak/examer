package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.QuestionDTO;

import java.util.List;

public class ExamDTO {

    private Long id;
    private String user;
    private byte[] audioRecord;
    List<QuestionDTO> questionDTOList;

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

    public List<QuestionDTO> getQuestionDTOList() {
        return questionDTOList;
    }

    public void setQuestionDTOList(List<QuestionDTO> questionDTOList) {
        this.questionDTOList = questionDTOList;
    }
}
