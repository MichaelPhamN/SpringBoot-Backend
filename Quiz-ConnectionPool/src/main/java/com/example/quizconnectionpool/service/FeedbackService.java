package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Feedback;

import java.util.List;

public interface FeedbackService {
    int createFeedback(Feedback feedback);
    int updateFeedback(Feedback feedback);
    Feedback findFeedbackByAccountId(int account_id);
    List<Feedback> getAllFeedbacks();
    double getAvgRate();
    int countRate(int rate);
}
