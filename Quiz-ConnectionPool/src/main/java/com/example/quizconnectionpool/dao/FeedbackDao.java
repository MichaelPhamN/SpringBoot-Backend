package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Feedback;

import java.util.List;

public interface FeedbackDao {
    int createFeedback(Feedback feedback);
    int updateFeedback(Feedback feedback);
    Feedback findFeedbackByAccountId(int account_id);
    List<Feedback> getAllFeedbacks();
    double getAvgRate();
    int countRate(int rate);
}
