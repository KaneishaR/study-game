package com.kcodes.studygame.dto;

import com.kcodes.studygame.model.Answer;
import com.kcodes.studygame.model.Topic;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class QuestionDto {

    @NotNull
    @NotEmpty
    private String question;

    @NotNull
    @NotEmpty
    private Topic topic;

    @NotNull
    @NotEmpty
    private Set<String> questionAnswers = new HashSet<>();


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<String> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(Set<String> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
