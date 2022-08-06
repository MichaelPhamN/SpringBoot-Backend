package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.model.Quiz;
import com.example.quizconnectionpool.service.impl.CategoryServiceImpl;
import com.example.quizconnectionpool.service.impl.QuestionServiceImpl;
import com.example.quizconnectionpool.service.impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    QuizServiceImpl quizService;

    @GetMapping("/account")
    public ResponseEntity<List<Quiz>> getAllQuizzes(@RequestParam int acct_id, @RequestParam int cat_id) {
        List<Quiz> quizzes = quizService.findQuizzes(acct_id, cat_id);
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/account/{acctId}")
    public ResponseEntity<List<Quiz>> findQuizzes(@PathVariable int acctId) {
        List<Quiz> quizzes = quizService.findQuizzes(acctId);
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Quiz>> findQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/countQuizzes")
    public ResponseEntity<Integer> countQuizzes(@RequestParam int acct_id, @RequestParam int category_id) {
        int count = quizService.countQuizzes(acct_id, category_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> findQuizById(@PathVariable int id) {
        Quiz quiz = quizService.findQuizById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping("/create")
    public int createQuiz(@RequestBody Quiz quiz) {
        int executedRow = quizService.createQuiz(quiz);
        return executedRow;
    }

    @PutMapping("/update-quiz-category")
    public int updateQuiz(@RequestParam int id, @RequestParam String quizName, @RequestParam int catId) {
        int executedRow = quizService.updateQuiz(id, quizName, catId);
        return executedRow;
    }

    @PutMapping("/update-score")
    public int updateQuiz(@RequestParam int id, @RequestParam double score) {
        int executedRow = quizService.updateQuiz(id, score);
        return executedRow;
    }
}
