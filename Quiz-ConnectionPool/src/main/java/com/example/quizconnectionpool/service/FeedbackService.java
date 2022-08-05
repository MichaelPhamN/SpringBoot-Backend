package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Feedback;

import java.util.List;

public interface FeedbackService {
    int createFeedback(Integer a_id, Integer stars, String comment);
    int updateFeedback(Integer a_id, Integer stars, String comment);
    Feedback findFeedbackByUserId(Integer userId);
    List<Feedback> getAllFeedbacks();
    double getAvgRate();
    int countRate(Integer rate);
}
