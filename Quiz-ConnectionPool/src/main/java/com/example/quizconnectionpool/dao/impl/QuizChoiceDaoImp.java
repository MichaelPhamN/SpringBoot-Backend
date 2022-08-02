package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.dao.QuizChoiceDao;
import com.example.quizconnectionpool.model.QuizChoice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizChoiceDaoImp implements QuizChoiceDao {
    @Override
    public List<QuizChoice> findQuizChoiceByQuizId(Integer quizId) {
        return null;
    }

    @Override
    public List<QuizChoice> findQuizChoiceByQuestionId(Integer questionId) {
        return null;
    }
}
