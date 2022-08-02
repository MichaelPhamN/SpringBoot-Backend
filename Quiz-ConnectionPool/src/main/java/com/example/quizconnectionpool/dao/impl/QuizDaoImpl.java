package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.dao.QuizDao;
import com.example.quizconnectionpool.model.Account;
import com.example.quizconnectionpool.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class QuizDaoImpl implements QuizDao {
    @Override
    public Integer createQuiz(Integer userId, String name, String category, Date startTime) {
        return null;
    }

    @Override
    public Quiz findLastQuiz(Integer userId, String category) {
        return null;
    }

    @Override
    public List<Quiz> findQuiz(Account user, String category) {
        return null;
    }

    @Override
    public List<Quiz> findQuiz(Integer userId) {
        return null;
    }

    @Override
    public Quiz findQuizById(Integer id) {
        return null;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return null;
    }

    @Override
    public Integer createQuizQuestion(Integer quizId, Integer choiceQuestionId) {
        return null;
    }

    @Override
    public Integer updateQuizQuestion(Integer quizId, Integer choiceQuestionId, String answer) {
        return null;
    }

    @Override
    public Integer updateQuiz(Integer quizId, Date finishTime) {
        return null;
    }

    @Override
    public Integer updateQuiz(Integer quizId, Integer score) {
        return null;
    }

    @Override
    public Integer countQuiz(Integer userId, String category) {
        return null;
    }
}
