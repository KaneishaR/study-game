package com.kcodes.studygame.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "game_question")
public class GameQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;

    @Column(name = "game_result", nullable = false)
    private String gameResult;

    @Column(name = "game_questiom", nullable = false)
    private String gameQuestion;

    @Column(name = "game_questiom", nullable = false)
    private Set<GameAnswer> answers;

    public GameQuestion(Question question){
        this.gameQuestion = question.getQuestion();
        question.getQuestionAnswers().stream().forEach((Answer ans)->this.answers.add(new GameAnswer(ans)));
        this.gameResult = "new game";
    }

    public GameQuestion() {
    }

    public GameQuestion(Integer id, String gameResult, String gameQuestion, Set<GameAnswer> answers) {
        this.id = id;
        this.gameResult = gameResult;
        this.gameQuestion = gameQuestion;
        this.answers = answers;
    }

    public GameQuestion(String gameResult, String gameQuestion, Set<GameAnswer> answers) {
        this.gameResult = gameResult;
        this.gameQuestion = gameQuestion;
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public String getGameQuestion() {
        return gameQuestion;
    }

    public void setGameQuestion(String gameQuestion) {
        this.gameQuestion = gameQuestion;
    }

    public Set<GameAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<GameAnswer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameQuestion)) return false;
        GameQuestion that = (GameQuestion) o;
        return getId().equals(that.getId()) && getGameResult().equals(that.getGameResult()) && getGameQuestion().equals(that.getGameQuestion()) && getAnswers().equals(that.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGameResult(), getGameQuestion(), getAnswers());
    }

    @Override
    public String toString() {
        return "GameQuestion{" +
                "id=" + id +
                ", gameResult='" + gameResult + '\'' +
                ", gameQuestion='" + gameQuestion + '\'' +
                ", answers=" + answers +
                '}';
    }
}
