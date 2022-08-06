package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.model.Question;
import com.example.quizconnectionpool.service.impl.CategoryServiceImpl;
import com.example.quizconnectionpool.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    QuestionServiceImpl questionService;

    @GetMapping("")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable int id) {
        Question question = questionService.findQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/{catName}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String catName) {
        List<Question> questions = questionService.getQuestionsByCategory(catName);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/create")
    public int createQuestion(@RequestBody Question question) {
        int executedRow = questionService.createQuestion(question);
        return executedRow;
    }

    @PutMapping("/update")
    public int updateQuestion(@RequestBody Question question) {
        int executedRow = questionService.updateQuestion(question);
        return executedRow;
    }
}
