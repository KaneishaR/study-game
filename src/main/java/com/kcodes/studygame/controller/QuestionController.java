package com.kcodes.studygame.controller;

import com.kcodes.studygame.model.Question;
import com.kcodes.studygame.model.Topic;
import com.kcodes.studygame.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService service){this.questionService=service;}

    @GetMapping(value = "/")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping(value = "/{id}")
    public Question getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }

    @GetMapping(value = "/{topic}")
    public Set<Question> getQuestionByTopic(@PathVariable Topic topic){
        return questionService.getAllQuestionsByTopic(topic);
    }
}
