package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.QuizChoiceDaoImp;
import com.example.quizconnectionpool.model.QuizChoice;
import com.example.quizconnectionpool.service.QuizChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizChoiceServiceImp implements QuizChoiceService {
    @Autowired
    private QuizChoiceDaoImp quizChoiceDao;
    @Override
    public List<QuizChoice> findQuizChoiceByQuizId(Integer quizId) {
        return quizChoiceDao.findQuizChoiceByQuizId(quizId);
    }

    @Override
    public List<QuizChoice> findQuizChoiceByQuestionId(Integer questionId) {
        return quizChoiceDao.findQuizChoiceByQuestionId(questionId);
    }
}
