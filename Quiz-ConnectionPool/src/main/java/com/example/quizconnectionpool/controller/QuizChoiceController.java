package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.QuizChoice;
import com.example.quizconnectionpool.service.impl.QuizChoiceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizchoice")
public class QuizChoiceController {
    @Autowired
    QuizChoiceServiceImp quizChoiceServiceImp;

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizChoice>> findQuizChoiceByQuizId(@PathVariable int quizId) {
        List<QuizChoice> quizChoices = quizChoiceServiceImp.findQuizChoiceByQuizId(quizId);
        return new ResponseEntity<>(quizChoices, HttpStatus.OK);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<QuizChoice>> findQuizChoiceByQuestionId(@PathVariable int questionId) {
        List<QuizChoice> quizChoices = quizChoiceServiceImp.findQuizChoiceByQuestionId(questionId);
        return new ResponseEntity<>(quizChoices, HttpStatus.OK);
    }
}
