package com.kcodes.studygame.service;

import com.kcodes.studygame.model.Answer;
import com.kcodes.studygame.repositories.AnswerRepo;

public class AnswerService {

    private AnswerRepo answerRepo;

    public AnswerService(AnswerRepo repo){
        this.answerRepo = repo;
    }

    public Answer saveAnswer(Answer answer){
        return answerRepo.save(answer);
    }
}
