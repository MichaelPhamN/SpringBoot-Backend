package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.model.Feedback;
import com.example.quizconnectionpool.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public Integer createFeedback(Integer userId, Integer rate, String comment) {
        return null;
    }

    @Override
    public Integer updateFeedback(Integer userId, Integer rate, String comment) {
        return null;
    }

    @Override
    public Feedback findFeedbackByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return null;
    }

    @Override
    public Double getAvgRate() {
        return null;
    }

    @Override
    public Integer countRate(Integer rate) {
        return null;
    }
}
