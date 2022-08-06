package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.FeedbackDaoImpl;
import com.example.quizconnectionpool.model.Feedback;
import com.example.quizconnectionpool.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDaoImpl feedbackDao;
    @Override
    public int createFeedback(Feedback feedback) {
        return feedbackDao.createFeedback(feedback);
    }

    @Override
    public int updateFeedback(Feedback feedback) {
        return feedbackDao.updateFeedback(feedback);
    }

    @Override
    public Feedback findFeedbackByAccountId(int account_id) {
        return feedbackDao.findFeedbackByAccountId(account_id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    @Override
    public double getAvgRate() {
        return feedbackDao.getAvgRate();
    }

    @Override
    public int countRate(int rate) {
        return feedbackDao.countRate(rate);
    }
}
