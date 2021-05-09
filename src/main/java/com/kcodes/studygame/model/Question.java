package com.kcodes.studygame.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToMany
    @JoinTable(
            name = "question_answer",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private Set<Answer> questionAnswers;

    public Question() {
    }

    public Question(String question, Set<Answer> questionAnswers) {
        this.question = question;
        this.questionAnswers = questionAnswers;
    }

    public Question(Integer id, String question, Set<Answer> questionAnswers) {
        this.id = id;
        this.question = question;
        this.questionAnswers = questionAnswers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Answer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(Set<Answer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }
}
