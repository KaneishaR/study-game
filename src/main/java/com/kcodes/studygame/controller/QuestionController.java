package com.kcodes.studygame.controller;

import com.kcodes.studygame.model.Question;
import com.kcodes.studygame.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
