package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Feedback;

import java.util.List;

public interface FeedbackService {
    Integer createFeedback(Integer userId, Integer rate, String comment);
    Integer updateFeedback(Integer userId, Integer rate, String comment);
    Feedback findFeedbackByUserId(Integer userId);
    List<Feedback> getAllFeedbacks();
    Double getAvgRate();
    Integer countRate(Integer rate);
}
