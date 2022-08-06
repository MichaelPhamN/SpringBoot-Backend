package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.QuestionDaoImpl;
import com.example.quizconnectionpool.model.Question;
import com.example.quizconnectionpool.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDaoImpl questionDao;
    @Override
    public int createQuestion(Question question) {
        return questionDao.createQuestion(question);
    }

    @Override
    public int updateQuestion(Question question) {
        return questionDao.updateQuestion(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.getQuestionsByCategory(category);
    }

    @Override
    public Question findQuestionById(int id) {
        return questionDao.findQuestionById(id);
    }
}
