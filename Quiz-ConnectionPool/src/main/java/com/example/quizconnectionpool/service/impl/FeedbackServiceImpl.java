package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.Feedback;
import com.example.quizconnectionpool.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackService feedbackService;
    @Override
    public int createFeedback(Integer a_id, Integer stars, String comment) {
        return feedbackService.createFeedback(a_id, stars, comment);
    }

    @Override
    public int updateFeedback(Integer a_id, Integer stars, String comment) {
        return feedbackService.updateFeedback(a_id, stars, comment);
    }

    @Override
    public Feedback findFeedbackByUserId(Integer a_id) {
        return feedbackService.findFeedbackByUserId(a_id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @Override
    public double getAvgRate() {
        return feedbackService.getAvgRate();
    }

    @Override
    public int countRate(Integer rate) {
        return feedbackService.countRate(rate);
    }
}
