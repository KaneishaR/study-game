package com.kcodes.studygame.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "game_result", nullable = false)
    private Float result;

    @OneToMany(mappedBy = "game")
    private Set<GameQuestion> questions;

    @ManyToOne @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Game() {
    }

    public Game(Integer id, Float result, Set<GameQuestion> questions, User user) {
        this.gameId = id;
        this.result = result;
        this.questions = questions;
        this.user = user;
    }

    public Game(Float result, Set<GameQuestion> questions, User user) {
        this.result = result;
        this.questions = questions;
        this.user = user;
    }

    public Integer getId() {
        return gameId;
    }

    public void setId(Integer id) {
        this.gameId = id;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }

    public Set<GameQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<GameQuestion> questions) {
        this.questions = questions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return getId().equals(game.getId()) && getResult().equals(game.getResult()) && getQuestions().equals(game.getQuestions()) && getUser().equals(game.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getResult(), getQuestions(), getUser());
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + gameId +
                ", result=" + result +
                ", questions=" + questions +
                ", user=" + user +
                '}';
    }
}

