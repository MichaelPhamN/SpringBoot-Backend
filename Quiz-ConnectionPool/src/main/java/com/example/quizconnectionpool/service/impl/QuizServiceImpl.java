package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.QuizDaoImpl;
import com.example.quizconnectionpool.model.Quiz;
import com.example.quizconnectionpool.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizDaoImpl quizDao;

    @Override
    public List<Quiz> findQuizzes(int acct_id, int cat_id) {
        return quizDao.findQuizzes(acct_id, cat_id);
    }

    @Override
    public List<Quiz> findQuizzes(int acct_id) {
        return quizDao.findQuizzes(acct_id);
    }

    @Override
    public Quiz findQuizById(int id) {
        return quizDao.findQuizById(id);
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        return quizDao.getAllQuizzes();
    }

    @Override
    public int createQuiz(Quiz quiz) {
        return quizDao.createQuiz(quiz);
    }

    @Override
    public int updateQuiz(int quizId, String quizName, int catId) {
        return quizDao.updateQuiz(quizId, quizName, catId);
    }

    @Override
    public int updateQuiz(int quizId, double score) {
        return quizDao.updateQuiz(quizId, score);
    }

    @Override
    public int countQuizzes(int accountId, int catId) {
        return quizDao.countQuizzes(accountId, catId);
    }
}
