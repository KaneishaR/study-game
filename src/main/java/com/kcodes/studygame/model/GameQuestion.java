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

    @Column(name = "game_question", nullable = false)
    private String gameQuestion;

    @ManyToMany
    @JoinTable(
            name = "question_answers",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "game_answer_id"))
    private Set<GameAnswer> gameQuestionAnswers;

    @ManyToOne @JoinColumn(name = "gameId", nullable = false)
    private Game game;

    public GameQuestion(Question question){
        this.gameQuestion = question.getQuestion();
        question.getQuestionAnswers().stream().forEach((Answer ans)->this.gameQuestionAnswers.add(new GameAnswer(ans)));
        this.gameResult = "new game";
    }

    public GameQuestion() {
    }

    public GameQuestion(Integer id, String gameResult, String gameQuestion, Set<GameAnswer> answers) {
        this.id = id;
        this.gameResult = gameResult;
        this.gameQuestion = gameQuestion;
        this.gameQuestionAnswers = answers;
    }

    public GameQuestion(String gameResult, String gameQuestion, Set<GameAnswer> answers) {
        this.gameResult = gameResult;
        this.gameQuestion = gameQuestion;
        this.gameQuestionAnswers = answers;
    }

    public GameQuestion(String gameResult, String gameQuestion, Set<GameAnswer> answers, Game game) {
        this.gameResult = gameResult;
        this.gameQuestion = gameQuestion;
        this.gameQuestionAnswers = answers;
        this.game = game;
    }

    public GameQuestion(Integer id, String gameResult, String gameQuestion, Set<GameAnswer> answers, Game game) {
        this.id = id;
        this.gameResult = gameResult;
        this.gameQuestion = gameQuestion;
        this.gameQuestionAnswers = answers;
        this.game = game;
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
        return gameQuestionAnswers;
    }

    public void setAnswers(Set<GameAnswer> answers) {
        this.gameQuestionAnswers = answers;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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
                ", answers=" + gameQuestionAnswers +
                '}';
    }
}
