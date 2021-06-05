package com.kcodes.studygame.service;

import com.kcodes.studygame.dto.QuestionDto;
import com.kcodes.studygame.model.Answer;
import com.kcodes.studygame.model.Question;
import com.kcodes.studygame.model.Topic;
import com.kcodes.studygame.repositories.AnswerRepo;
import com.kcodes.studygame.repositories.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionService {

    private QuestionRepo questionRepo;
    private AnswerRepo answerRepo;

    public QuestionService (QuestionRepo questionRepo1, AnswerRepo answerRepo1){
        this.answerRepo =answerRepo1;
        this.questionRepo=questionRepo1;
    }

    public Question getQuestionById(int id){
        Question question = questionRepo.getOne(id);
        return question;
    }

    public List<Question> getAllQuestions(){
        List<Question> questions = questionRepo.findAll();
        return questions;
    }

    public Question saveQuestion(QuestionDto questionDto){
      Question newQuestion = new Question();
      newQuestion.setQuestion(questionDto.getQuestion());
      newQuestion.setTopic(questionDto.getTopic());
      questionDto.getQuestionAnswers().forEach(s -> {
              Answer ans = answerRepo.save(new Answer(s));
              newQuestion.getQuestionAnswers().add(ans);
      });
         Question persistedQuestion = questionRepo.save(newQuestion);
         persistedQuestion.getQuestionAnswers().forEach(answer -> {
             answer.getQuestions().add(persistedQuestion);
             answerRepo.save(answer);
         });
         return persistedQuestion;
    }

    public Set<Question> getAllQuestionsByTopic(Topic topic){
        return questionRepo.getByTopic(topic);
    }
}
