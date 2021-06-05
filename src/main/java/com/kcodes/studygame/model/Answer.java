package com.kcodes.studygame.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer id;

    @Column(name = "answer", nullable = false)
    private String answer;

    @ManyToMany(mappedBy = "questionAnswers")
    private Set<Question> questions = new HashSet<>();

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public Answer(Integer id, String answer, Set<Question> questions) {
        this.id = id;
        this.answer = answer;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer1 = (Answer) o;
        return getId().equals(answer1.getId()) && getAnswer().equals(answer1.getAnswer()) && getQuestions().equals(answer1.getQuestions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnswer(), getQuestions());
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", questions=" + questions +
                '}';
    }
}
