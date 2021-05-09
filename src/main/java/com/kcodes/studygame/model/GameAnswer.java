package com.kcodes.studygame.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "game_answer")
public class GameAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_answer_id")
    private Integer id;

    @Column(name = "answer", nullable = false)
    private String answer;

    @ManyToMany(mappedBy = "gameQuestionAnswers")
    private Set<GameQuestion> questions;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    public GameAnswer(Answer answer){
        this.answer = answer.getAnswer();
        answer.getQuestions().forEach((Question que)->this.questions.add(new GameQuestion(que)));
    }
}
