package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.Feedback;
import com.example.quizconnectionpool.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    FeedbackServiceImpl feedbackService;

    @GetMapping("")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/{acctId}")
    public ResponseEntity<Feedback> findFeedbackByAccountId(@PathVariable int acctId) {
        Feedback feedback = feedbackService.findFeedbackByAccountId(acctId);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @PostMapping("/create")
    public int createFeedback(@RequestBody Feedback feedback) {
        int executedRow = feedbackService.createFeedback(feedback);
        return executedRow;
    }

    @PutMapping("/update")
    public int updateFeedback(@RequestBody Feedback feedback) {
        int executedRow = feedbackService.updateFeedback(feedback);
        return executedRow;
    }

    @GetMapping("/getAvgRage")
    public ResponseEntity<Double> getAvgRate() {
        Double avgRate = feedbackService.getAvgRate();
        return new ResponseEntity<>(avgRate, HttpStatus.OK);
    }

    @GetMapping("/countRate/{stars}")
    public ResponseEntity<Integer> countRate(@PathVariable int stars) {
        int countRate = feedbackService.countRate(stars);
        return new ResponseEntity<>(countRate, HttpStatus.OK);
    }
}
