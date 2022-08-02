package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.dao.FeedbackDao;
import com.example.quizconnectionpool.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {
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
